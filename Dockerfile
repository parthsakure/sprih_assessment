FROM --platform=linux/arm64 mcr.microsoft.com/openjdk/jdk:17-azurelinux
WORKDIR /app
COPY target/sprih-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]