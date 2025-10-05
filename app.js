document.addEventListener("DOMContentLoaded", () => {

    const chatBox = document.getElementById("chat-box");
    const messageInput = document.getElementById("message-input");
    const sendButton = document.getElementById("send-button");

    const socket = new WebSocket("ws://localhost:8887");

    socket.onopen = (event) => {
        console.log("Conexão com o servidor estabelecida!");
        addMessageToChat("Sistema: Conectado ao servidor!");
    };

    socket.onmessage = (event) => {
        console.log("Mensagem recebida do servidor:", event.data);
        addMessageToChat(event.data);
    };

    socket.onclose = (event) => {
        console.log("Conexão com o servidor foi fechada.");
        addMessageToChat("Sistema: Você foi desconectado.");
    };

    socket.onerror = (error) => {
        console.error("Ocorreu um erro no WebSocket:", error);
        addMessageToChat("Sistema: Erro de conexão. O servidor está offline?");
    };

    function addMessageToChat(message) {
        const messageElement = document.createElement("p");
        messageElement.textContent = message;
        chatBox.appendChild(messageElement);
        chatBox.scrollTop = chatBox.scrollHeight;
    }

    function sendMessage() {
        const message = messageInput.value;
        if (message.trim() !== "") {
            socket.send(message);
            messageInput.value = "";
            messageInput.focus();
        }
    }
    
    sendButton.addEventListener("click", sendMessage);

    messageInput.addEventListener("keypress", (event) => {
        if (event.key === "Enter") {
            sendMessage();
        }
    });
});

