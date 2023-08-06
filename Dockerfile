FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/alcohol-0.0.5-spirits.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]