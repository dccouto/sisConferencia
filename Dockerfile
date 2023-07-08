ARG REGISTRY=docker.io/library

# runner
FROM ${REGISTRY}/openjdk:11-jdk-slim AS runner 
RUN apt-get update; \
    apt-get install -y --no-install-recommends maven ca-certificates-java ca-certificates; \
    apt-get autoremove -y;

WORKDIR /app
ENTRYPOINT env && mvn spring-boot:run -U

# build
FROM ${REGISTRY}/maven:3.6.3-jdk-11-slim AS build
WORKDIR /home/app
COPY .m2/settings.xml /home/app/.m2/settings.xml
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml -s /home/app/.m2/settings.xml clean install -U

# release
FROM ${REGISTRY}/openjdk:11-jre-slim AS release
WORKDIR /home/app
COPY --from=build /home/app/target/primeira-infancia-api-*.jar /usr/local/lib/primeira-infancia-api.jar
EXPOSE 8080
ENV TZ="America/Sao_Paulo"
ENTRYPOINT ["java","-jar","/usr/local/lib/primeira-infancia-api.jar"]
