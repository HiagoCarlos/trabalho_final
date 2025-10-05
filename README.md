# Chat em Tempo Real com WebSocket e Java

## Visão Geral do Projeto

Este projeto é uma aplicação de chat em tempo real desenvolvida em **Java** e **JavaScript**, utilizando a biblioteca **`java-websocket`** para a comunicação. O objetivo é demonstrar a comunicação bidirecional e instantânea entre um servidor Java e múltiplos clientes web, permitindo uma experiência de chat fluida.

---

## Tecnologias Utilizadas

**Back-end:**
* **Java:** Linguagem principal do servidor.
* **java-websocket:** Biblioteca para implementação do servidor WebSocket.
* **slf4j-api:** Biblioteca de logging usada como dependência pelo `java-websocket`.

**Front-end:**
* **HTML:** Estrutura da página do chat.
* **CSS:** Estilização e layout da interface.
* **JavaScript:** Lógica do cliente para comunicação com o servidor.

---

## Como Executar o Projeto

Para rodar o projeto em sua máquina, siga os passos abaixo.

### 1. Estrutura do Projeto

Certifique-se de que a estrutura de pastas do seu projeto está organizada da seguinte forma, com os arquivos `.jar` das bibliotecas na pasta `lib`:
trabalho_final/
├── src/
│   └── ChatServer.java
│   └── (outros arquivos .java)
└── lib/
└── Java-WebSocket-1.5.7.jar
└── slf4j-api-2.0.13.jar

### 2. Compilar o Servidor

Abra o terminal e navegue até a pasta **`src`**. Em seguida, execute o comando de compilação. Isso garantirá que o Java encontre todas as dependências necessárias para compilar seu código.

```bash
javac -cp ../lib/Java-WebSocket-1.5.7.jar;../lib/slf4j-api-2.0.13.jar ChatServer.java
```

### Executar o Servidor
Após a compilação, execute o servidor a partir da mesma pasta **``src``** usando o comando abaixo. Ele também inclui as bibliotecas no classpath.
```bash
java -cp .;../lib/Java-WebSocket-1.5.7.jar;../lib/slf4j-api-2.0.13.jar ChatServer
```
### Como usar o Cliente
Para se conectar ao chat e começar a conversar, siga estas instruções:

Ajuste o IP: Abra o arquivo **``app.js``** em um editor de texto. Na linha que define a conexão WebSocket (linha 6), altere o IP para o endereço IP do computador onde o servidor está rodando.

Abra no Navegador: Abra o arquivo **``index.html``** em seu navegador web favorito (como Chrome, Firefox, etc.).

Conecte e Converse: A página irá se conectar automaticamente ao servidor. Digite seu nome e suas mensagens e converse com os demais clientes conectados.
