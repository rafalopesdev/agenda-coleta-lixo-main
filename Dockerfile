# Use uma imagem do OpenJDK como base
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado para dentro do container
COPY target/agenda-coleta-lixo-0.0.1-SNAPSHOT.jar app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expõe a porta 8080
EXPOSE 8080
