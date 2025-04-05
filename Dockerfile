FROM amazoncorretto:17-alpine
LABEL authors="ernestoV"
WORKDIR /app
COPY ./target/alumnos_rest-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]