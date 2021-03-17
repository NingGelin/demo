#ARG         SINO_REPO=xast.test.com
FROM        ngl525/java
MAINTAINER  NingGelin
WORKDIR     /usr/local/SINO/demo
ADD         build/libs/demo.jar /usr/local/SINO/demo
CMD         ["java","-jar","demo.jar"]