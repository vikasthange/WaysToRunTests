#
# Build stage
#
FROM maven:3.6-jdk-8-slim AS build
WORKDIR /project
COPY src /project/src
COPY pom.xml /project
RUN mvn clean package

#
# Package stage
#
FROM maven:3.6-jdk-8-slim
WORKDIR /project
ADD endpoint.sh /project/endpoint.sh
RUN ["chmod", "+x", "/project/endpoint.sh"]
COPY --from=build /project/src/main/resources /project/resources
COPY --from=build /project/target/RunTestsInContainer-1.0-SNAPSHOT-jar-with-dependencies.jar /project/test.jar
ENTRYPOINT ["sh","/project/endpoint.sh"]