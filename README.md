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
--link postgres:readings \
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

see script.sql file