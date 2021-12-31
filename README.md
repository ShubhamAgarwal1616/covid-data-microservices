### Covid-Data-Microservices

#### Run microservices
- ##### Method 1
    - run both microservices individually on different port by following steps in README.md present in both microservices
- ##### Method 2
    - go to `covid-data-demo` directory and run `./mvnw clean package` to build a jar file. Make sure DB container is up and running while building the jar as while building jar file proper connection to db is established and queries are run.      
    - go to `covid-data-query` directory and run `./mvnw clean package` to build a jar file. Make sure DB container is up and running while building the jar as while building jar file proper connection to db is established and queries are run.
    - ` To run DB for both the microservices run postgres containers for both individually or comment code for spring boot services in docker-compose and run docker-compose up. Please make sure to expose correct dp ports for db containers if you are using docker compose to start db containers`
    - Uncomment code in docker-compose if used the above step to run DB containers.
    - run `docker-compose-up` in `covid-data-microservices` directory and check your app is running at port 8081.
