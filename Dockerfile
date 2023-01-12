FROM openjdk:17-alpine
#COPY . /app
#WORKDIR /app
#RUN ./gradlew build
COPY ./build/libs/URLShortening-0.0.1-SNAPSHOT.jar /URLShortening.jar
#<path-to-jar-file>
EXPOSE 8080
ENTRYPOINT ["java","-jar","/URLShortening.jar"]