# Etapa 1: build da aplicação
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: imagem final
FROM openjdk:17-jdk-slim

WORKDIR /app

# Cria diretório para banco de dados persistente (caso H2)
RUN mkdir -p /app/data

# Expondo porta padrão Spring Boot
EXPOSE 8080

# Copiando JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Executando a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
