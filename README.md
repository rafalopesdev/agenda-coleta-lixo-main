# **Agenda de coleta de lixo**

Este projeto é uma API para gerenciar a agenda de coleta de lixo, desenvolvida em Java com Spring Boot e utilizando MongoDB como banco de dados.

## **Pré-requisitos**
Para rodar este projeto, você precisa das seguintes ferramentas:

Java: Java 21 (ou versão compatível)

MongoDB: A API utiliza MongoDB Atlas para armazenar dados

Git: Para clonar o projeto do GitHub

IntelliJ IDEA (ou outra IDE Java): Para abrir e executar o projeto

Docker (opcional): Caso deseje rodar a aplicação em containers

Permissões para o Maven Wrapper: É necessário dar permissão de execução ao Maven Wrapper antes de rodar o projeto com o comando:

chmod +x mvnw

## **Observação:**
A execução dos testes automatizados foi configurada para rodar localmente, sem integração com ferramentas externas como Azure DevOps, GitHub Actions ou Jenkins. Esta escolha se deve ao fato de que a atividade solicitava uma execução de testes "simples", sendo a integração com ferramentas de CI/CD opcional.

"3. Execução de testes: Deixar a execução dos testes para simples, seja rodando localmente ou integrado com um pipeline de CI/CD utilizando ferramentas como Azure DevOps, GitHub Actions, Jenkins ou outras."
## **Funcionalidades**

A API oferece os seguintes endpoints:

POST /api/lixo: Cria um novo registro de coleta.

GET /api/lixo: Retorna todos os registros de coleta.

GET /api/lixo/{id}: Retorna um registro de coleta específico pelo ID.

PUT /api/lixo/{id}: Atualiza um registro de coleta pelo ID.

DELETE /api/lixo/{id}: Exclui um registro de coleta pelo ID.

## **Clonando o Projeto**
git clone https://github.com/rafalopesdev/agenda-coleta-lixo-main.git

## **Construção do Projeto**
No terminal, dentro da pasta do projeto, execute o comando:

./mvnw clean install

## **Executando a API**
Para iniciar a API, execute o comando abaixo no terminal (ou rode diretamente pela IDE):

Direto no arquivo:

src/main/java/br.com.fiap.agenda_coleta_lixo.AgendaColetaLixoApplication
Ou
./mvnw spring-boot:run

A API estará disponível em http://localhost:8080/api/lixo

## **Rodando os Testes Automatizados**
Direto no arquivo:

src/test/java/br/com/fiap/agenda_coleta_lixo/GerenciarAgendaColetaLixoTest.java

Usando o Maven

./mvnw test

Usando o Script de Testes
Permissão: chmod +x run_tests.sh
Executar: ./run_tests.sh





