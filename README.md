# Meu Yoga App - Projeto Integrador

## Descrição do Projeto

Este projeto é um aplicativo de yoga desenvolvido para a disciplina de Projeto Integrador do curso de Análise e Desenvolvimento de Sistemas do quarto semestre. O objetivo é fornecer uma plataforma para praticantes de yoga, oferecendo aulas organizadas por níveis e com temporizadores integrados. O aplicativo foi desenvolvido utilizando tecnologias modernas e robustas, como Java Spring, PostgreSQL, HTML, CSS, JavaScript e Node.js.

## Funcionalidades

- **Cadastro de Usuário**: Permite que novos usuários se cadastrem no sistema fornecendo informações básicas.
- **Login de Usuário**: Autenticação de usuários já cadastrados para acesso seguro às funcionalidades do aplicativo.
- **Aulas de Yoga**: Disponibilização de aulas divididas em quatro níveis (iniciante, intermediário, avançado e especialista).
- **Temporizador**: Integração de um temporizador para cada aula, ajudando os praticantes a acompanhar o tempo de cada sessão.

## Tecnologias Utilizadas

- **Backend**: Desenvolvido em Java utilizando o framework Spring.
- **Banco de Dados**: PostgreSQL, para armazenamento seguro e eficiente dos dados dos usuários e das aulas.
- **Frontend**: HTML, CSS e JavaScript para a criação de uma interface de usuário interativa e responsiva.
- **Node.js**: Utilizado na API das posições de yoga para fornecer informações detalhadas e atualizadas sobre cada posição.

## Estrutura do Projeto

### Backend

O backend foi construído com Java Spring, seguindo uma arquitetura em camadas para melhor organização e manutenção do código. As principais camadas são:

- **Controladores (Controllers)**: Responsáveis por lidar com as requisições HTTP e retornar as respostas apropriadas.
- **Serviços (Services)**: Contêm a lógica de negócio e regras de aplicação.
- **Repositórios (Repositories)**: Realizam a comunicação com o banco de dados PostgreSQL.

### Frontend

O frontend foi desenvolvido com HTML, CSS e JavaScript, proporcionando uma experiência de usuário agradável e intuitiva. A estrutura do frontend inclui:

- **Páginas de Cadastro e Login**: Formulários para entrada de dados dos usuários.
- **Página de Aulas**: Exibição das aulas organizadas por nível, com botões para iniciar o temporizador.
- **Temporizador**: Implementado em JavaScript para contagem regressiva e controle de tempo das sessões de yoga.

### Node.js

Node.js foi utilizado na API das posições de yoga. Esta API fornece informações detalhadas sobre cada posição de yoga, como nome, descrição e benefícios, que são integradas ao frontend para enriquecer a experiência do usuário.

## Instalação e Execução

### Pré-requisitos

- JDK 11 ou superior
- PostgreSQL
- Node.js
- NPM (Node Package Manager)

### Passos para Instalação

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/seu-usuario/yoga-app.git
   ```

2. **Configuração do Backend**:
   - Navegue até o diretório `backend`:
     ```bash
     cd /backend
     ```
   - Configure o banco de dados PostgreSQL no arquivo `application.properties`.
   - Execute o backend:
     ```bash
     ./mvnw spring-boot:run
     ```

3. **Configuração da API de Posições de Yoga**:
   - Navegue até o diretório `yoga-positions-api`:
     ```bash
     cd ../yoga-api
     ```
   - Instale as dependências:
     ```bash
     npm install
     ```
   - Execute a API:
     ```bash
     node app.js
     ```

4. **Configuração do Frontend**:
   - Navegue até o diretório `frontend`:
     ```bash
     cd ../frontend
     ```
   - Instale as dependências:
     ```bash
     npm install
     ```
   - Execute o frontend:
     ```bash
     npm start
     ```

## Contribuidores

- Isabella de Melo Moreira (github.com/isamoreira)
- Nome do Aluno 2
- Nome do Aluno 3
- Nome do Aluno 4



Sinta-se à vontade para contribuir com este projeto ou entrar em contato para mais informações.

