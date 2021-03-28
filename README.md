### ARHSCube test

This Springboot application exposes several Restful API endpoints to manage users

A user consists of three fields: first name, last name and email
1. The restful API has to allow create/update/delete and search of users
2. The users have to be stored in an in-memory database (no need for SQL)
3. Every time a user is created/updated/deleted or searched an event should be sent to a message broker queue
4. Implement a queue listener that would simply log the event's details/payload.
5. The in-memory database should load in memory a bunch of users from a CSV (with the structure first_name, last_name, email) file during init phase

Unit/Integration tests not required.

### Rest API
GET localhost:8080/users - lists all users
GET localhost:8080/users/{id} - finds user by id
POST localhost:8080/users - creates new user
PUT localhost:8080/users - updates user
DELETE localhost:8080/users/{id} - deletes user by id


### Running

Use the following commands to work with this project

Build it
```mvn clean install```

Run it
```mvn run```

It can also easily be run via the IDE just like an other springboot application e.g. to run via Intellij simply locate the ServiceApplication class within the application module and select "Run".

After spring boot application starts, you can call new API endpoint using the following command line:\
```curl -X GET "http://localhost:8080/users" -H "accept: application/json"```

Alternatively you can see the response in a browser:
```http://localhost:8080/users```



No Rights Reserved   
Rokas Valantinas 2021