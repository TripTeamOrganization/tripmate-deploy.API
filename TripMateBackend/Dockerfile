FROM eclipse-temurin:22-jdk
ARG JAR_FILE=target/tripmate-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} tripmate.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","tripmate.jar"]
