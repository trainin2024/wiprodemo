FROM openjdk:8u131-jdk-alpine
EXPOSE 7000
COPY ./target/aws-dept-feign-0.0.1-SNAPSHOT.jar  aws-dept-feign-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/aws-dept-feign-0.0.1-SNAPSHOT.jar"]