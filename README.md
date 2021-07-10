# TransactionRepo
This repository contains a spring boot application which will perform transaction related operation on accounts

## Instruction
### Java version
Java 8 is used in this project.
### Dependency management
Gradle is used as dependency management tool
### Database creation
This application uses mysql database. Create a new database named "test". If you name different, you need change the database name in application.properties.
Database is given in sql folder. You can import it in your database(database.sql).
### Application port
Application is running in default 8080 port
### Endpoints

There are two end points in this application

#### 1. Application Status
##### Request
`GET /api/v1/app/status`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/app/status
    
##### Response
    Application is running...
#### 2. Perform transaction
##### Request
`POST /api/v1/transaction`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/transaction

##### Requestbody
    {
        "requestId": "A32W4ER2342",
        "requester": "XYZ App",
        "transactionType": "VFJBTlNGRVI=",
        "sourceAccountNumber": "MzIzNDEyMDA5MjM0ODc=",
        "amount": "MTUwMC41MA==",
        "destinationAccountNumber": "MDAxMjQxMDA5MjExNDM5",
        "note": "Transferring amount"
    }


##### Response
    Transaction successful
