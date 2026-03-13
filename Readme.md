# 📑 Sistema de Gerenciamento de Funcionários

![Java](https://img.shields.io/badge/Java-25-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4-green)
![Database](https://img.shields.io/badge/Database-SQLite-blue)
![Build](https://img.shields.io/badge/Build-Gradle-orange)

Este é um projeto **CRUD (Create, Read, Update, Delete)** desenvolvido com **Spring Boot 4** e **Java 25**.

O sistema permite **gerenciar o cadastro de funcionários**, utilizando um banco de dados local **SQLite**, facilitando portabilidade, testes e desenvolvimento rápido.

---

# 🚀 Tecnologias Utilizadas

- **Java 25**
- **Spring Boot 4**
- **Spring Data JPA**
- **SQLite**
- **Lombok**
- **Gradle**

---

# 🏗️ Arquitetura e Decisões Técnicas

O projeto segue boas práticas de arquitetura backend.

### 📦 Repository Pattern
O padrão **Repository** foi utilizado para separar a lógica de acesso ao banco de dados da lógica da aplicação.  
Isso facilita futuras migrações de banco (por exemplo, de **SQLite para PostgreSQL**).

### 📤 DTO (Data Transfer Object)

DTOs foram implementados para evitar expor diretamente as entidades do banco de dados na API.

Isso melhora:

- segurança
- controle de dados enviados
- desacoplamento entre camadas

### 🔨 Fluent Builder

Foi utilizado o `@Builder` do **Lombok** para criação de objetos de forma mais legível e fluida.

---

# 📂 Estrutura do Projeto

```
src
 └── main
     └── java
         └── com.exemplo.funcionarios
             ├── controllers
             ├── dto
             ├── models
             ├── repository
             └── FuncionariosApplication.java
```

---

# 🛠️ Como Executar o Projeto

## Pré-requisitos

- **JDK 25**
- **Gradle**
- IDE recomendada: IntelliJ IDEA

---

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/Richard-Prado/funcionarios-api.git
```

---

## 2️⃣ Abrir o projeto

Abra o arquivo:

```
build.gradle
```

A IDE reconhecerá automaticamente o projeto **Gradle**.

---

## 3️⃣ Banco de dados

O arquivo

```
Database.db
```

será criado automaticamente **na raiz do projeto** ao iniciar a aplicação.

---

## 4️⃣ Rodar a aplicação

Execute a classe:

```
FuncionariosApplication
```

---

# 📡 Endpoints da API

| Método | Endpoint                       | Descrição                         |
|--------|--------------------------------|-----------------------------------|
| GetAll | `/funcionarios`                | Obter todos os funcionário        |
| POST   | `/funcionarios/salvar`         | Cadastra um funcionário           |
| PUT    | `/funcionarios/atualizar/{id}` | Atualiza um funcionário existente |
| DELETE | `/funcionarios/deletar/{id}`   | Remove um funcionário             |

---

# 📄 Exemplo de JSON

### Criar funcionário

POST `/funcionarios/salvar`

```json
{
  "nome": "João Silva",
  "cargo": "Desenvolvedor",
  "salario": 4500
}
```

---

# 📌 Observações

Este projeto foi desenvolvido com foco em **aprendizado de desenvolvimento backend com Spring Boot**, aplicando conceitos como:

- arquitetura em camadas
- DTO
- Repository Pattern
- APIs REST
- persistência com JPA