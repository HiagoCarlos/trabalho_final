import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class ChatServer extends WebSocketServer {

    private Set<WebSocket> connections = Collections.synchronizedSet(new HashSet<>());
    public ChatServer(int port) {
        super(new InetSocketAddress(port));
        System.out.println("Servidor de Chat WebSocket aguardando conexões na porta: " + port);
    }
    
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        connections.add(conn); 
        String clientAddress = conn.getRemoteSocketAddress().getAddress().getHostAddress();
        System.out.println("Nova conexão de: " + clientAddress);
        
        broadcast("Sistema: " + clientAddress + " entrou no chat.");
    }
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        connections.remove(conn); 
        String clientAddress = conn.getRemoteSocketAddress().getAddress().getHostAddress();
        System.out.println("Conexão fechada de: " + clientAddress);
        broadcast("Sistema: " + clientAddress + " saiu do chat.");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        String clientAddress = conn.getRemoteSocketAddress().getAddress().getHostAddress();
        System.out.println("Mensagem de " + clientAddress + ": " + message);
       
        broadcast(clientAddress + ": " + message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.err.println("Ocorreu um erro na conexão " + (conn != null ? conn.getRemoteSocketAddress() : "desconhecida") + ": " + ex.getMessage());
        ex.printStackTrace();
    }
    
    @Override
    public void onStart() {
        System.out.println("Servidor iniciado com sucesso!");
    }

    @Override
    public void broadcast(String message) {
        synchronized (connections) {
            for (WebSocket client : connections) {
                client.send(message);
            }
        }
    }  
    public static void main(String[] args) {
        int port = 8887;
        try {
            ChatServer server = new ChatServer(port);
            server.start(); 
        } catch (Exception e) {
            System.err.println("Não foi possível iniciar o servidor na porta " + port);
            e.printStackTrace();
        }
    }
}
