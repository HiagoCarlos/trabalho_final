import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

public class ChatServer extends WebSocketServer {

    private Set<WebSocket> connections;
    private WebSocket leader;

    public ChatServer(int port) {
        super(new InetSocketAddress(port));
        connections = new HashSet<>();
        leader = null;
        System.out.println("Servidor de Chat WebSocket aguardando conexões na porta: " + port);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        connections.add(conn);
        String clientAddress = getClientIdentifier(conn);
        System.out.println("Nova conexão de: " + clientAddress);

        if (leader == null) {
            electNewLeader(conn, "O primeiro a entrar se tornou o líder.");
        }
        
        String welcomeMessage = createJsonMessage("system_notification", "Sistema", clientAddress + " entrou no chat.", false);
        broadcast(welcomeMessage);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        connections.remove(conn);
        String clientAddress = getClientIdentifier(conn);
        System.out.println("Conexão fechada de: " + clientAddress);

        String disconnectMessage = createJsonMessage("system_notification", "Sistema", clientAddress + " saiu do chat.", false);
        broadcast(disconnectMessage);

        if (conn.equals(leader)) {
            if (!connections.isEmpty()) {
                electNewLeader(connections.iterator().next(), "O líder anterior saiu. Um novo líder foi eleito.");
            } else {
                leader = null;
                System.out.println("A sala está vazia. Não há líder.");
            }
        }
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        String clientAddress = getClientIdentifier(conn);
        System.out.println("Mensagem de " + clientAddress + ": " + message);

        boolean isLeader = conn.equals(leader);
        String jsonMessage = createJsonMessage("user_message", clientAddress, message, isLeader);
        broadcast(jsonMessage);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        if (conn != null) {
            connections.remove(conn);
        }
        System.err.println("Ocorreu um erro na conexão: " + (conn != null ? getClientIdentifier(conn) : "desconhecida"));
        ex.printStackTrace();
    }
    
    @Override
    public void onStart() {
        System.out.println("Servidor iniciado com sucesso!");
    }
    private void electNewLeader(WebSocket newLeader, String reason) {
        leader = newLeader;
        System.out.println("Novo líder eleito: " + getClientIdentifier(leader));
        String leaderMessage = createJsonMessage("system_notification", "Sistema", reason + " O novo líder é " + getClientIdentifier(leader) + ".", false);
        broadcast(leaderMessage);
    }
    @Override
    public void broadcast(String message) {
        for (WebSocket client : connections) {
            client.send(message);
        }
    }
    private String getClientIdentifier(WebSocket conn) {
        return conn.getRemoteSocketAddress().getAddress().getHostAddress();
    }

    private String createJsonMessage(String type, String user, String text, boolean isLeader) {
        String escapedText = text.replace("\"", "\\\"");
        return String.format(
            "{\"type\": \"%s\", \"user\": \"%s\", \"text\": \"%s\", \"isLeader\": %b}",
            type, user, escapedText, isLeader
        );
    }

    public static void main(String[] args) {
        int port = 8887; 
        new ChatServer(port).start();
    }
}

