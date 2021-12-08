FROM openjdk:11 
EXPOSE 8080
COPY target/WebTiengAnh-0.0.1-SNAPSHOT.jar WebTiengAnh-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "WebTiengAnh-0.0.1-SNAPSHOT.jar"]