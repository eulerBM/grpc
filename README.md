<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <title>gRPC CRUD Service</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      line-height: 1.6;
      max-width: 800px;
      margin: auto;
      padding: 20px;
      background-color: #f9f9f9;
    }
    h1, h2, h3 {
      color: #2c3e50;
    }
    code {
      background-color: #ecf0f1;
      padding: 2px 4px;
      border-radius: 4px;
      font-family: monospace;
    }
    pre {
      background-color: #ecf0f1;
      padding: 10px;
      border-radius: 4px;
      overflow-x: auto;
    }
    ul {
      list-style-type: disc;
      margin-left: 20px;
    }
    a {
      color: #2980b9;
      text-decoration: none;
    }
    a:hover {
      text-decoration: underline;
    }
    .section {
      margin-bottom: 40px;
    }
    .image-container {
      text-align: center;
      margin: 20px 0;
    }
    .image-container img {
      max-width: 100%;
      height: auto;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
  </style>
</head>
<body>

  <h1>gRPC CRUD Service</h1>

  <p>Este projeto demonstra como desenvolver uma aplicação simples de CRUD (Create, Read, Update, Delete) utilizando gRPC. O serviço gerencia uma coleção de itens, como registros de usuários, produtos ou notas, estabelecendo uma comunicação eficiente entre cliente e servidor.</p>

  <div class="image-container">
    <img src="image/create.png" alt="Exemplo de uso do serviço gRPC">
    <img src="image/deleted.png" alt="Exemplo de uso do serviço gRPC">
    <img src="image/getAll.png" alt="Exemplo de uso do serviço gRPC">
  </div>

  <div class="section">
    <h2>🔧 Tecnologias Utilizadas</h2>
    <ul>
      <li><strong>Java</strong></li>
      <li><strong>gRPC</strong></li>
      <li><strong>PostgreSQL</strong></li>
      <li><strong>Gradle</strong></li>
      <li><strong>Docker</strong></li>
    </ul>
  </div>

  <div class="section">
    <h2>📁 Estrutura do Projeto</h2>
    <pre>
grpc/
├── docker/
├── gradle/
├── image/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
├── .gitattributes
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
└── settings.gradle
    </pre>
  </div>

  <div class="section">
    <h2>🚀 Como Executar</h2>
    <ol>
      <li><strong>Clone o repositório:</strong>
        <pre><code>git clone https://github.com/eulerBM/grpc.git
cd grpc</code></pre>
      </li>
      <li><strong>Compile o projeto:</strong>
        <pre><code>./gradlew build</code></pre>
      </li>
      <li><strong>Execute o servidor gRPC:</strong>
        <pre><code>./gradlew run</code></pre>
      </li>
      <li><strong>Execute o cliente gRPC:</strong>
        <p>(Instruções específicas para executar o cliente devem ser fornecidas aqui, dependendo da implementação.)</p>
      </li>
    </ol>
  </div>

  <div class="section">
    <h2>✅ Funcionalidades</h2>
    <ul>
      <li>Criação de novos itens.</li>
      <li>Leitura de itens existentes.</li>
      <li>Atualização de itens.</li>
      <li>Remoção de itens.</li>
    </ul>
  </div>

  <div class="section">
    <h2>🤝 Contribuição</h2>
    <p>Contribuições são bem-vindas! Sinta-se à vontade para abrir <em>issues</em> ou enviar <em>pull requests</em>.</p>
  </div>

  <div class="section">
    <h2>📄 Licença</h2>
    <p>Este projeto está licenciado sob a licença MIT. Consulte o arquivo <code>LICENSE</code> para mais detalhes.</p>
  </div>

  <footer>
    <p>Para mais informações, visite o repositório oficial: <a href="https://github.com/eulerBM/grpc">eulerBM/grpc</a>.</p>
  </footer>

</body>
</html>
