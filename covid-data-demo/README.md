#### Run Application
- Start a postgres db container and create a database required by app (covid_data) using commands mentioned in `Set up postgresql server image` section
- Run spring boot app using command line commands in `Run spring boot application from command line`
 
 #### Set up microsoft sql server image
  https://docs.microsoft.com/en-us/sql/linux/quickstart-install-connect-docker?view=sql-server-ver15&pivots=cs1-bash
 - docker pull mcr.microsoft.com/mssql/server:2019-latest
 - docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=password" -e "MSSQL_PID=Express" -p 1433:1433 -d mcr.microsoft.com/mssql/server:2019-latest
 
 #### Set up postgresql server image
- ##### pull an run image
    - docker pull postgres:latest
    - docker run --name psql1 -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres

- ##### test container and run sql commands
    - docker exec -it psql1 bash
    - su postgres
    - psql
    - CREATE DATABASE <db name>
    - \conninfo (to get connection info)
    - \q (to quit)
    - \l (get all databases)
    - \dt (get all tables in current databse)
    - \c <database_name> (switch database)
    - \d <table_name> (describe a table)
    - \? (enlist all available commands)
    - \h DROP TABLE (know syntax of a command)
    - https://www.datacamp.com/community/tutorials/10-command-line-utilities-postgresql?utm_source=adwords_ppc&utm_medium=cpc&utm_campaignid=14989519638&utm_adgroupid=127836677279&utm_device=c&utm_keyword=&utm_matchtype=&utm_network=g&utm_adpostion=&utm_creative=332602034364&utm_targetid=aud-392016246653:dsa-429603003980&utm_loc_interest_ms=&utm_loc_physical_ms=20471&gclid=CjwKCAiAtdGNBhAmEiwAWxGcUu3UNLmpuLlI32sWcImx3qwy5zmV8TueMk5Y6cbXCRYW3xC7AMeA2hoCCSYQAvD_BwE

#### connect spring boot to postgresql database
- pull and run docker container for postgresql as per above container
- create a database that you want to connect with by going inside container using above mentioned commands
- add configuration in application.properties for database connection

#### Run spring boot application from command line
- ##### maven Application
    - ./mvnw spring-boot:run ( to run application )
    - ./mvnw clean package ( to build jar file )
- ##### gradle Application
    - ./gradlew bootRun ( to run application )
    - ./gradlew build ( to build jar file )