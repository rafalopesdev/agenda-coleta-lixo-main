FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY . .

# Compile e empacote o projeto
RUN mvn clean package

# Criar uma imagem
FROM openjdk:17-jdk-slim

# Definir o diretório
WORKDIR /app

COPY --from=build /app/target/agenda-coleta-lixo-0.0.1-SNAPSHOT.jar app.jar

# Rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]


# Dockerfile

FROM openjdk:21
WORKDIR /app
COPY target/agenda-coleta-lixo-0.0.1-SNAPSHOT.jar app.jar

# Comando para rodar os testes
CMD ["java", "-jar", "app.jar", "&&", "mvn", "test"]