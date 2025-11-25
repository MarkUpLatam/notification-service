# ====== STAGE 1: Build ======
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar el archivo pom.xml y descargar dependencias primero (cache)
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Copiar el código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# ====== STAGE 2: Runtime ======
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copiar el jar generado desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Puerto de tu microservicio
EXPOSE 8084

# Variables recomendadas para producción
ENV JAVA_OPTS="-Xms256m -Xmx512m"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
