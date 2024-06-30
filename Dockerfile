FROM openjdk:17

WORKDIR /app

COPY target/MediConnect-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "MediConnect-0.0.1-SNAPSHOT.jar"]