FROM gradle:8.10.2-jdk23-alpine

ENV APP_HOME=/opt/app

WORKDIR $APP_HOME

COPY . .

RUN gradle build -x test

RUN cp -R /opt/app/build/libs/* /opt/app/apps.jar

RUN gradle clean

EXPOSE 8080

CMD ["java", "-jar", "apps.jar"]
