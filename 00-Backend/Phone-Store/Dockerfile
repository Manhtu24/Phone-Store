FROM  openjdk:17

ARG FILE_JAR=target/*.jar

ADD ${FILE_JAR} phone-store.jar

ENTRYPOINT ["java","-jar","phone-store.jar"]

EXPOSE 8286

#mvn clean package ỏ mvn clean install

