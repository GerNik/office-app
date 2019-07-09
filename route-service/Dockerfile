FROM java:8-jre

ADD ./build/libs/route-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/route-service.jar"]

EXPOSE 7000