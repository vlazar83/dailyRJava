

jenkins image was created using:

docker build -t my-jenkins-image .


Running it:

docker run -p 8080:8080 -p 50000:50000 --restart=on-failure -v jenkins_home:/var/jenkins_home my-jenkins-image

