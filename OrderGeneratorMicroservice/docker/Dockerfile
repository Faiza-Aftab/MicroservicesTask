
FROM adoptopenjdk/openjdk13:ubi
RUN mkdir /opt/app
COPY OrderGenerator-0.0.1-SNAPSHOT.jar /opt/app/OrderGenerator.jar
CMD ["java", "-jar", "/opt/app/OrderGenerator.jar”]