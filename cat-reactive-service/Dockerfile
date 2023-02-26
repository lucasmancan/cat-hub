FROM gradle:7.1.0-jdk11 AS BUILD

WORKDIR /app
COPY . .

RUN ls

RUN gradle clean build --info --no-daemon

# Run stage
FROM openjdk:11
ARG JAR_FILE=build/libs/cat-reactive-service.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9090

ENTRYPOINT ["java","-jar","/app.jar"]