# 📚 Projeto: Biblioteca com Spring Boot e GraphQL

Este projeto implementa um sistema básico de gerenciamento de livros, empréstimos e usuários utilizando Spring Boot e GraphQL. É possível realizar operações CRUD (Create, Read, Update, Delete) para os principais modelos do sistema.
# 🚀 Tecnologias Utilizadas

- Java 21+
- Spring Boot (Framework principal)
- Lombok (Redução de boilerplate de código)

# 📋 Pré-requisitos

Antes de executar o projeto, garanta que você tenha instalado:

- Java JDK 21+
- Maven (para gerenciamento de dependências)


# ⚙️ Configuração do Projeto

### Clone o repositório:

`git clone https://github.com/io.git`

`cd nome-do-repositorio`

### Configure o Maven: Se necessário, atualize as dependências utilizando:

`mvn clean install`

### Execute o projeto:

`mvn spring-boot:run`

Acesse a interface do GraphQL: O projeto usa a interface de teste do GraphQL Playground ou Altair, disponível em:

[http://localhost:8080/graphiql?](http://localhost:8080/graphiql?)

📊 Schema GraphQL

O sistema disponibiliza os seguintes types, queries e mutations:
Types

    Book: Representa um livro.
    Loan: Representa um empréstimo de um livro.
    User: Representa um usuário do sistema.
    Enums:
        Status (AVAILABLE, LOAN)
        AgeGroup (CHILDREN, TEEN, ADULT)

# Queries

### Book Queries
```graphql
    getAllBooks: [Book]
    getBookById(id: ID!): Book
    getBooksByYear(year: Int!): [Book]
    getBooksByAuthor(author: String!): [Book]
    getBooksByCategory(category: String!): [Book]
    getBooksByAgeGroup(ageGroup: AgeGroup!): [Book]
```
### Loan Queries
```graphql
getAllLoans: [Loan]
getLoanById(id: ID!): Loan
getLoansByBookId(bookId: ID!): [Loan]
getLoansByUserId(userId: ID!): [Loan]
getLoansByStatus(status: Status!): [Loan]
```
### User Queries
```graphql
getAllUsers: [User]
getUsersByName(firstName: String!): [User]
```
Mutations

### Book Mutations
```graphql
createBook(title: String!, year: Int!, status: Status!, author: String!, category: String!, ageGroup: AgeGroup!): Book!
updateBook(id: ID!, title: String, year: Int, status: Status, author: String, category: String, ageGroup: AgeGroup): Book!
deleteBook(id: ID!): String!
```
### Loan Mutations
```graphql
createLoan(bookId: ID!, userId: ID!, status: Status!, returnDate: String!): Loan!
updateLoan(id: ID!, status: Status, returnDate: String): Loan!
deleteLoan(id: ID!): String!
```
### User Mutations
```graphql
createUser(firstName: String!, age: Int!, tel: String!): User!
updateUser(id: ID!, firstName: String, age: Int, tel: String): User!
deleteUser(id: ID!): String!
```
🧪 Exemplos de Testes
### Criar Livros
```graphql
mutation {
  createBook(
    title: "Dom Quixote", 
    year: 1605, 
    status: AVAILABLE, 
    author: "Miguel de Cervantes", 
    category: "Clássico", 
    ageGroup: ADULT
  ) {
    id
    title
  }
}
```
###  Buscar Todos os Livros
```graphql
query {
  getAllBooks {
    id
    title
    author
    year
  }
}
```
### Atualizar um Livro
```graphql
mutation {
  updateBook(
    id: "1", 
    title: "Dom Quixote - Edição Revisada"
  ) {
    id
    title
  }
}
```
### Deletar um Livro
```graphql
mutation {
  deleteBook(id: "1")
}
```
# 📄 Licença

Este projeto é distribuído sob a licença MIT. Sinta-se livre para utilizá-lo e modificá-lo conforme necessário.