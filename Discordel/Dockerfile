FROM alpine:3.16
RUN apk add openjdk11 maven
COPY . /var/discordel
WORKDIR /var/discordel
RUN mvn clean package
CMD mvn exec:java -Dexec.mainClass="Main"
