#FROM openjdk:17 as build
#
#WORKDIR /app
#
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#
#RUN chmod +x mvnw
#RUN ./mvnw install -DskipTests
#
#COPY src ./src
#
#RUN ./mvnw clean package
#
#FROM openjdk:17-jdk-alpine
#

#EXPOSE 9090
#
#ENTRYPOINT ["java","-jar","/app/app.jar"]



#FROM openjdk:19 as build
#
#WORKDIR /app
#
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#
#RUN chmod +x mvnw
#RUN ./mvnw install -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
#
#RUN ls -la target/
#COPY target/lab1-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 9090
#
#ENTRYPOINT ["java","-jar","/app/app.jar"]
FROM amazoncorretto:17-alpine

WORKDIR /app

EXPOSE 8080

COPY . .

RUN chmod +x mvnw && ./mvnw dependency:resolve


CMD ["./mvnw", "spring-boot:run"]
