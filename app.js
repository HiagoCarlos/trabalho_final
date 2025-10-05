document.addEventListener("DOMContentLoaded", () => {
    const chatBox = document.getElementById("chat-box");
    const messageInput = document.getElementById("message-input");
    const sendButton = document.getElementById("send-button");

    const socket = new WebSocket("ws://localhost:8887");

    socket.onopen = (event) => {
        console.log("Conexão estabelecida!");
    };

    socket.onclose = (event) => {
        console.log("Conexão fechada.");
        addMessage({
            type: 'system_notification',
            text: 'Você foi desconectado. Tente atualizar a página.'
        });
    };

    socket.onerror = (error) => {
        console.error("Erro no WebSocket:", error);
        addMessage({
            type: 'system_notification',
            text: 'Erro de conexão. O servidor pode estar offline.'
        });
    };

    socket.onmessage = (event) => {
        const messageData = JSON.parse(event.data);
        addMessage(messageData);
    };

    function addMessage(data) {
        const messageElement = document.createElement("div");
        messageElement.classList.add("message");

        switch (data.type) {
            case 'user_message':
                messageElement.classList.add("user-message");
                
                const userSpan = document.createElement("span");
                userSpan.className = "user-name";
                userSpan.textContent = data.user + ": ";

                if (data.isLeader) {
                    const crown = document.createElement("span");
                    crown.className = "leader-badge";
                    crown.textContent = "👑 ";
                    messageElement.appendChild(crown);
                    userSpan.classList.add("leader");
                }
                
                const textNode = document.createTextNode(data.text);
                messageElement.appendChild(userSpan);
                messageElement.appendChild(textNode);
                break;

            case 'system_notification':
                messageElement.classList.add("system-notification");
                if (data.text.includes("entrou")) {
                    messageElement.classList.add("connect");
                } else if (data.text.includes("saiu") || data.text.includes("desconectado")) {
                    messageElement.classList.add("disconnect");
                }
                messageElement.textContent = data.text;
                break;
            
            default:
                messageElement.textContent = data.text;
        }

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

