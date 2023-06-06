# Github Repository Details Integration Microservice

This application extracts data about user’s repositories from Github’s REST Api and returns it to the consumer in the application/json format, after filtering out forked repositories.

The application should be running out of the box, so it doesn’t require any additional setup, other than that needed to run any simple Spring Boot app (like having JDK installed on the machine).

In order to obtain the data about user’s repositories from this microservice one must send http request to this endpoint:
* http://localhost:8080/api/get


Containing such headers as:
* Accept with value application/json
 

And the desired user’s username passed in the body in this format:
````
{
"userName":"Stawczyk"
}
````
Alternatively here is the cUrl to an example of a request:
````
curl --location --request GET 'http://localhost:8080/api/get' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{"userName":"Stawczyk"}'
````