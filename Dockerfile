FROM gradle:8.10.2-jdk23-alpine

ENV APP_HOME=/opt/app

WORKDIR $APP_HOME

COPY . .

RUN gradle build -x test

RUN cp -R /opt/app/build/libs/*.jar /opt/app/

RUN ls -lh $APP_HOME

RUN gradle clean

EXPOSE $PORT

CMD ["java", "-jar", "apps.jar"]
