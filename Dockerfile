FROM openjdk:17
WORKDIR /app
COPY target/ping-app.jar /app/ping-app.jar
CMD ["java", "-jar", "ping-app.jar"]
