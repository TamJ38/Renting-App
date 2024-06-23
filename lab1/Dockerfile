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
#COPY --from=build /app/target/*.jar app.jar
#
#EXPOSE 9090
#
#ENTRYPOINT ["java","-jar","/app/app.jar"]



FROM openjdk:19 as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#COPY --from=build /app/target/*.jar app.jar
COPY target/*.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java","-jar","/app/app.jar"]

