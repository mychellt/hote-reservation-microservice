FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/hotel-reservation.jar /app/hotel-reservation-service.jar

EXPOSE 8081

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/hotel-reservation.jar"]

