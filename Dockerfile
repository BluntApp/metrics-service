FROM java:8
ADD target/metrics-service.jar metrics-service.jar
ENTRYPOINT ["java","-jar","metrics-service.jar"]
