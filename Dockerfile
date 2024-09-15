# First Step: Build
FROM maven:3.8.4-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests


# Verwende das offizielle OpenJDK-Basisimage
FROM openjdk:17-jdk-slim

# Setze das Arbeitsverzeichnis
WORKDIR /app

# Kopiere die JAR-Datei ins Arbeitsverzeichnis
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponiere den Port
EXPOSE 8080

# Definiere den Befehl zum Ausführen der Anwendung
ENTRYPOINT ["java", "-jar", "app.jar"]
