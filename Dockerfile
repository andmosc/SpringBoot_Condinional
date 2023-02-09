FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8081

COPY build/libs/ConditionalApp-0.0.1-SNAPSHOT.jar ConditionalApp.jar

CMD ["java", "-jar", "ConditionalApp.jar"]