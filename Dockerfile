ENV         NAME=demo
#ARG         SINO_REPO=xast.test.com
FROM        ngl525/java
MAINTAINER  NingGelin
WORKDIR     /usr/local/SINO/$NAME/
RUN         mkdir /usr/local/SINO/$NAME
ADD         build/libs/$NAME.jar /usr/local/SINO/$NAME
RUN         rm -rf /usr/local/SINO/$NAME/$NAME.jar
CMD         ["java","-jar","demo.jar"]