Chat em Tempo Real com Java (WebSocket) e Frontend Web
📖 Sobre o Projeto
Este projeto consiste em um sistema de chat em tempo real construído sobre a arquitetura cliente-servidor. O backend é desenvolvido em Java, utilizando a tecnologia WebSocket para permitir comunicação bidirecional e de baixa latência. O frontend é uma aplicação web moderna, construída com HTML5, CSS3 e JavaScript, que se conecta ao servidor para proporcionar uma experiência de chat fluida e interativa.

A aplicação permite que múltiplos usuários se conectem simultaneamente e troquem mensagens, que são distribuídas (broadcast) para todos os participantes da sala em tempo real.

🎯 Objetivo Principal
O desenvolvimento deste sistema atende ao objetivo acadêmico de "Desenvolver um sistema distribuído básico utilizando sockets, focando nos fundamentos de comunicação e coordenação".

Sistema Distribuído: A arquitetura cliente-servidor, onde clientes (navegadores) e o servidor (aplicação Java) operam como nós independentes que se comunicam através de uma rede, caracteriza este projeto como um sistema distribuído.

Sockets: A comunicação é baseada em WebSockets, uma tecnologia moderna que opera sobre um socket TCP, cumprindo o requisito de uso de sockets para a troca de mensagens.

Comunicação e Coordenação: O servidor Java atua como o coordenador central, gerenciando o estado das conexões ativas. A comunicação é padronizada através de um protocolo simples baseado em JSON, permitindo que o frontend diferencie mensagens de usuários de notificações do sistema, um fundamento crucial em sistemas distribuídos.

📸 Pré-visualização
[Imagem do chat em tempo real em ação]
Aqui você pode adicionar um screenshot da sua aplicação funcionando.

🚀 Tecnologias Utilizadas
O projeto foi construído com as seguintes tecnologias e bibliotecas:

Backend (Servidor)
Java (JDK 21 ou superior): Linguagem principal para a lógica do servidor.

Java-WebSocket: Biblioteca para a implementação do servidor WebSocket, facilitando o gerenciamento de conexões e eventos.

SLF4J API: Biblioteca de logging, uma dependência do Java-WebSocket.

Frontend (Cliente)
HTML5: Para a estruturação semântica da página de chat.

CSS3: Para a estilização moderna, com layout baseado em Flexbox e um tema escuro.

JavaScript (ES6+): Para a lógica do lado do cliente, manipulação do DOM e comunicação com o servidor WebSocket.

✨ Funcionalidades
Comunicação em Tempo Real: Mensagens são enviadas e recebidas instantaneamente sem a necessidade de recarregar a página.

Múltiplos Clientes: O servidor é multithreaded e suporta várias conexões simultâneas.

Broadcast de Mensagens: Uma mensagem enviada por um cliente é distribuída para todos os outros clientes conectados.

Notificações de Sistema: O chat exibe notificações quando um usuário entra ou sai da sala.

Protocolo JSON: A comunicação entre cliente e servidor utiliza o formato JSON para estruturar os dados das mensagens.

Interface Moderna: O frontend possui um design responsivo e agradável, inspirado em aplicações de chat modernas.

⚙️ Como Executar o Projeto
Siga os passos abaixo para compilar e executar a aplicação em sua máquina local.

Pré-requisitos
JDK (Java Development Kit) versão 11 ou superior instalado e configurado no PATH do sistema.

Um navegador web moderno (Google Chrome, Firefox, etc.).

(Opcional, mas recomendado) Visual Studio Code com o "Extension Pack for Java".

1. Estrutura de Pastas
Certifique-se de que sua estrutura de pastas está organizada da seguinte forma:

TRABALHO_FINAL/
├── lib/
|   ├── Java-WebSocket-1.5.7.jar
|   └── slf4j-api-2.0.13.jar
├── src/
|   └── ChatServer.java
├── bin/
├── index.html
├── style.css
└── app.js

2. Compilar o Servidor (Backend)
Abra um terminal ou prompt de comando na pasta raiz do projeto (TRABALHO_FINAL/) e execute o seguinte comando:

javac -cp "lib/*" -d bin src/ChatServer.java

Este comando compila o código-fonte da pasta src e coloca os arquivos .class na pasta bin, utilizando as bibliotecas da pasta lib.

3. Executar o Servidor (Backend)
No mesmo terminal, execute o comando abaixo para iniciar o servidor. Ele ficará aguardando por conexões na porta 8887.

No Windows:

java -cp "bin;lib/*" ChatServer

No Linux ou macOS:

java -cp "bin:lib/*" ChatServer

Você verá a mensagem Servidor iniciado com sucesso! no terminal. Mantenha este terminal aberto.

4. Abrir o Cliente (Frontend)
Navegue até a pasta raiz do projeto (TRABALHO_FINAL/) no seu explorador de arquivos.

Abra o arquivo index.html diretamente no seu navegador web.

Para simular múltiplos usuários, abra o mesmo arquivo index.html em outras abas ou janelas do navegador.

👨‍💻 Autor

<sub>Seu Nome Aqui</sub>

Feito com ❤️ por Seu Nome Aqui. Entre em contato!

https://www.linkedin.com/in/seu-linkedin/

📜 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.