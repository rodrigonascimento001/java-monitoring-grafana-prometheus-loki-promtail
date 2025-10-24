# Use uma imagem base do OpenJDK 21
FROM eclipse-temurin:21-jdk-jammy

# Crie o diretório de logs
RUN mkdir -p /var/log

# Copie o JAR da aplicação para o container
COPY target/*.jar app.jar

# Defina variáveis de ambiente (opcional)
ENV JAVA_OPTS=""
EXPOSE 8080
# Comando para rodar a aplicação e direcionar logs para /var/log/springboot.log
ENTRYPOINT java $JAVA_OPTS -jar app.jar > /var/log/springboot.log 2>&1