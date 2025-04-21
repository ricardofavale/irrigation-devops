# Etapa 1: Build do projeto
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Executar o JAR
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/irrigation-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
