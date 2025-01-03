FROM gradle:8.10.2-jdk23-alpine

ENV APP_HOME=/opt/app/

WORKDIR $APP_HOME

COPY . .

RUN gradle build -x test

RUN cp -R /opt/app/build/libs/*.jar $APP_HOME/apps.jar

RUN gradle clean

EXPOSE $PORT

CMD ["java", "-jar", "-Dspring.profiles.active=${PROFILES_ACTIVE}" , "apps.jar"]
