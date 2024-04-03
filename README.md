# dailyRJava
daily reading Backend - Java version

To run the PostgeSQL in docker locally:

docker run -d \
--name postgres \
-e POSTGRES_USER=admin \
-e POSTGRES_PASSWORD=admin \
-e POSTGRES_DB=readings \
-v pg_data:/var/lib/postgresql/data \
-p 5432:5432 \
postgres

Use adminer tool to see the DB content:

docker run -d \
--name adminer \
-p 8085:8080 \
--link readings-postgres-container:readings \
adminer

in the http://localhost:8085/?pgsql=db&username=admin&db=readings&ns=public
use for login:
Login System
PostgreSQL

Server
db

Username
admin

Password
•••••

Database
readings

---
SQL script to generate the DB table:

see db/init.sql file

The inserts are there using the script/data_extractor.py .
Copy over the generated output.sql content into the init.sql file in order to have the data seed.
After that build the postgre db docker image - see next point.

---
In case the docker-compose is used:

First build a docker image in the db folder!!:

cd db 
docker build -t readings-postgres .

docker-compose up -d

Then the adminer tool is accessible:
http://localhost:8085/?pgsql=readings-postgres&username=admin&db=readings&ns=public

---
build the spring backend:
cd .
docker build -t dailyrjava .

docker-compose up -d