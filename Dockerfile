FROM openjdk:21-ea-24-oracle

WORKDIR /app

COPY target/exp2_s4_briam_carrasco-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_KVB5FJFLZY575QGO /app/oracle_wallet

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]


