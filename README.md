# 💬 Chat em Tempo Real com Java (WebSocket) e Frontend Web
## 📖 Sobre o Projeto
Este projeto é um chat em tempo real feito em Java, usando WebSocket no servidor e uma página web no cliente. Ele permite que várias pessoas conversem ao mesmo tempo, enviando e recebendo mensagens instantaneamente, sem precisar recarregar a página. A ideia é simular um sistema distribuído simples, onde o servidor controla as conexões e os navegadores são os clientes.
## 🎯 Objetivo
Criar uma aplicação distribuída que usa sockets, aplicando o conceito de cliente-servidor. O servidor Java mantém as conexões e envia as mensagens para todos os usuários conectados. O navegador atua como cliente, mandando mensagens via WebSocket para o servidor. A comunicação é feita com mensagens em formato JSON, o que deixa mais fácil identificar o conteúdo trocado entre o servidor e os navegadores.
## 🚀 Tecnologias Utilizadas
**Servidor (Backend)**  
- Java (JDK 11 ou superior)  
- Biblioteca Java-WebSocket (1.5.7)  
- Biblioteca SLF4J (para logs internos da lib)  
**Cliente (Frontend)**  
- HTML5  
- CSS3  
- JavaScript (ES6)
## ✨ Funcionalidades
- Envio e recebimento de mensagens em tempo real  
- Notificação quando um novo usuário entra ou sai  
- Envio de mensagens para todos os clientes conectados  
- Interface simples e intuitiva  
- Sistema rodando em rede local
## ⚙️ Execução
Para rodar o projeto, basta compilar e executar o servidor Java com as bibliotecas Java-WebSocket e SLF4J adicionadas no classpath. Depois disso, abrir o arquivo HTML no navegador, que irá se conectar automaticamente ao servidor via WebSocket. Assim, vários navegadores podem ser abertos para simular diferentes usuários conectados ao mesmo tempo.
## 🧠 Conceito
O projeto segue o modelo cliente-servidor, onde o servidor central (em Java) é responsável por receber as mensagens e repassá-las aos clientes conectados. Ele mantém um conjunto de sessões ativas e realiza broadcast das mensagens. O navegador é o cliente, enviando e recebendo as mensagens via WebSocket. Essa abordagem demonstra a ideia de comunicação bidirecional entre processos em uma rede, que é a base de sistemas distribuídos.
## 📡 Comunicação
O protocolo WebSocket é usado para criar um canal persistente entre cliente e servidor. Diferente do HTTP comum, o WebSocket permite que o servidor envie mensagens para o cliente a qualquer momento, sem precisar de requisições constantes. Isso garante o funcionamento em tempo real e baixa latência, essencial para um chat. Toda mensagem enviada por um cliente é transformada em JSON e enviada para o servidor, que replica para todos os outros clientes conectados.
## 🎨 Interface
A interface é feita em HTML e CSS, com foco na simplicidade e funcionalidade. O JavaScript é responsável por conectar ao servidor, tratar os eventos de entrada e saída, e exibir as mensagens na tela de forma dinâmica. O estilo segue um tema escuro, deixando o visual mais agradável para o uso contínuo.
## 🔐 Rede
O servidor pode ser executado em qualquer computador da rede local. Os clientes precisam apenas substituir o endereço IP do servidor no código JavaScript para se conectar. Assim, o chat pode ser usado entre diferentes dispositivos conectados ao mesmo Wi-Fi, simulando uma rede distribuída real.
## 🧩 Conclusão
O projeto cumpre o objetivo de demonstrar o funcionamento de um sistema distribuído básico com sockets, aplicando os conceitos de comunicação, coordenação e paralelismo. Ele une Java no backend e tecnologias web no frontend, criando uma solução simples, funcional e fácil de entender.
