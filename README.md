# Kumulus Cadastro Pessoa

Sistema de cadastro de pessoas e endereços utilizando JSF, PrimeFaces, Spring e JPA com PostgreSQL.

---

## ✅ Pré-requisitos

Antes de começar, certifique-se de que você tem os seguintes itens instalados:

- **Java 8**
- **Eclipse IDE for Enterprise Java Developers**
- **Apache Tomcat 9**
- **Docker**
- **Git (opcional)**


---

## 🚀 Passos para Rodar o Projeto

### 1. Baixe o Projeto

Clone o repositório ou baixe o `.zip` e importe no Eclipse:

```bash
git clone [https://github.com/seu-usuario/kumulus-cadastro-pessoa.git](https://github.com/judsoncabral/kumulus-cadastro-pessoa.git)
```
### 2. Rode PostgresSql no docker com os seguintes comandos:
  docker run --name kumulus-postgres -e POSTGRES_DB=kumulus-rh -e POSTGRES_USER=kumulus-rh -e POSTGRES_PASSWORD=123456 -p 5432:5432  -d postgres

### 3. Inclua o projeto no tomcat 9 rode o projeto e acesse url: http://localhost:8080/kumulus-cadastro-pessoa/index.xhtml
