FROM java:8-jre

ADD ./build/libs/app.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/app.jar"]

EXPOSE 7000