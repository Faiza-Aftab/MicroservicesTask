

FROM adoptopenjdk/openjdk13:ubi
RUN mkdir /opt/app

COPY OrderProcessor-0.0.1-SNAPSHOT.jar /opt/app/OrderProcessor.jar
CMD ["java", "-jar", "/opt/app/OrderProcessor.jar”]