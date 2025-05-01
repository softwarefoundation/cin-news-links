FROM gradle:8.10.2-jdk23-alpine as build

ENV APP_HOME=/opt/app

WORKDIR $APP_HOME

COPY . .

RUN gradle build -x test

FROM amazoncorretto:23-alpine3.21 as run

COPY --from=build /opt/app/build/libs/* apps.jar

EXPOSE 8080

CMD ["java", "-jar", "apps.jar"]
