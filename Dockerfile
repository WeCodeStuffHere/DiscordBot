FROM openjdk:17
EXPOSE 8080
VOLUME /tmp
COPY .env target/.env
#ADD target/DiscordBot.jar DiscordBot.jar
ADD target/DiscordBot-jar-with-dependencies.jar DiscordBot-jar-with-dependencies.jar
ENV JAVA_OPTS=""
#ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /DiscordBot.jar"]
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /DiscordBot-jar-with-dependencies.jar"]
CMD ["./mvn", "clean package"]