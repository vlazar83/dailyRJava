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

-------
Backend server keystore pass : changeit

<<Side note: installing docker-compose on AWS instance:>>

Copy the appropriate docker-compose binary from GitHub:

sudo curl -L https://github.com/docker/compose/releases/download/1.22.0/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose

NOTE: to get the latest version (thanks @spodnet): sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose

Fix permissions after download:

sudo chmod +x /usr/local/bin/docker-compose

Verify success:

docker-compose version

<<End of side note>>


Running the certbot in docker:
sudo docker run -it --rm --name certbot             -v "/Users/I060663/AWS:/etc/letsencrypt"             -v "/Users/I060663/AWS:/var/lib/letsencrypt"             certbot/certbot certonly --manual --preferred-challenges dns

generate it for lutheran-readings.cloudns.asia

lookup the result:
https://toolbox.googleapps.com/apps/dig/#TXT/

_acme-challenge.lutheran-readings.cloudns.asia

put the generated keypair( PKCS#8 ) into a keystore.
Copy it to the dailyRJava roo folder, and run a new build.

docker build --platform=linux/amd64 -t dockerdoc83/dailyrjava:v1.01_linux .

docker push dockerdoc83/dailyrjava:v1.01_linux

adjust the docker-compose.yml file with the new version number
then copy it over to the AWS instance:

from the folder where the login keypair is located:
/AWS/keypair$ scp -i loginKeyPair.pem docker-compose.yml ec2-user@16.171.234.34:dailyReadings

On the computer install the new certificate in the keychain access - in roder to trust this Cert.
after the setup on the computer the following request might fail:

https://lutheran-readings.cloudns.asia:443/readings

https://block.opendns.com/? - because of this error.

switch to mobile Internet on the computer in order to make it work:

curl https://lutheran-readings.cloudns.asia:443/readings/1

---


So just to summarize in case of a backend code change:
 - change the code and build it with mvn clean install
 - build a new version from the backend image using:
 docker build --platform=linux/amd64 -t dockerdoc83/dailyrjava:v1.0<n>_linux .

 <n> stands for the new version number

 - push it to dockerhub:
 docker push dockerdoc83/dailyrjava:v1.0<n>_linux

 - adjust with the new version the docker-compose.yml file and copy it to the AWS server:
 cd /AWS/keypair
 touch docker-compose.yml
 scp -i loginKeyPair.pem docker-compose.yml ec2-user@16.171.234.34:dailyReadings

 - login to the AWS server using ssh and restart the docker-compose:
 docker-compose down
 docker-compose up -d

-----
Jenkins part

docker run -p 8080:8080 -p 50000:50000 --restart=on-failure -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts-jdk17

