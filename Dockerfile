FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
ENV JVM_HEAP_SIZE=1g
ENV HOST '0.0.0.0'
EXPOSE 8080
