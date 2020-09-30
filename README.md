# COMP5104
Repo for Comp COMP5104

Yu Sun
101138129

The following code contains two modules, one is for the client, another is for the server.

## system requirement
- java version 13
- maven 3.6.3


## Running code through IDEA
- Run:
```
Run the GameServer
Run the GameClient
```

## Running code through Terminal(With 3 players)
- Run:
```
mvn clean package
cd server/target
java -jar server-1.0-SNAPSHOT.jar 3

cd client/target 
java -jar client-1.0-SNAPSHOT.jar

cd client/target 
java -jar client-1.0-SNAPSHOT.jar

cd client/target 
java -jar client-1.0-SNAPSHOT.jar
```

## Running code through terminal for row 40
- Run:
```
mvn clean package
cd server/target
java -jar server-1.0-SNAPSHOT.jar 3

cd client/target 
java -jar client-1.0-SNAPSHOT.jar 40player1

cd client/target 
java -jar client-1.0-SNAPSHOT.jar 40player2

cd client/target 
java -jar client-1.0-SNAPSHOT.jar 40player3
```

## Running code through terminal for row 43
- Run:
```
mvn clean package
cd server/target
java -jar server-1.0-SNAPSHOT.jar 3

cd client/target 
java -jar client-1.0-SNAPSHOT.jar 43player1

cd client/target 
java -jar client-1.0-SNAPSHOT.jar 43player2

cd client/target 
java -jar client-1.0-SNAPSHOT.jar 43player3
```