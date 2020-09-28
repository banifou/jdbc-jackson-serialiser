# Quarkus Reproducer Project
GitHub issue: https://github.com/quarkusio/quarkus/issues/12345


Steps to reproduce
1. Create a postgres DB: `create user quarkus_test with password 'quarkus_test'; create database quarkus_test with owner quarkus_test encoding 'UTF8';` 
2. Create the DB schema `psql -d quarkus_test -f schema.sql`
3. Run the data.sql file `psql -d quarkus_test -f import.sql`
4. Compile native-image and execute process
5. run following on a terminal to execute requests and it will throw the error described in issue: `curl -i -X GET http://localhost:8080/api/books`.


# jdbc-jackson-temp project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `jdbc-jackson-serialiser-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/jdbc-jackson-serialiser-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/jdbc-jackson-serialiser-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.
