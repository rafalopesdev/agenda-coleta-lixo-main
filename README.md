# **Agenda de coleta de lixo urbano**

Este projeto é uma API para gerenciar a agenda de coleta de lixo,
desenvolvida em Java com Spring Boot e utilizando MongoDB como banco de dados.

# **Funcionalidades**

A API oferece os seguintes endpoints:

POST /api/lixo: Cria um novo registro de coleta.
GET /api/lixo: Retorna todos os registros de coleta.
GET /api/lixo/{id}: Retorna um registro de coleta específico pelo ID.
PUT /api/lixo/{id}: Atualiza um registro de coleta pelo ID.
DELETE /api/lixo/{id}: Exclui um registro de coleta pelo ID.

# _Pré-requisitos_
Java 21
Maven para gerenciamento de dependências
MongoDB para armazenamento de dados
Docker (opcional, caso deseje rodar a aplicação em containers)

# **Construção do Projeto**
mvn clean install

# **Execução dos Testes**
mvn test

# **Executando com Docker**
docker build -t agenda-coleta-lixo .

# **Executar o container:**
docker run -p 8080:8080 agenda-coleta-lixo

# **Integração Contínua (CI)**






