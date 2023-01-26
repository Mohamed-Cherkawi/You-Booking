FROM openjdk:17

ARG WAR_FILE=target/*.war

COPY ./target/YouBooking-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java", "-jar","app.war"]