ARG         REPO=hub.docker.com
#ARG         SINO_REPO=xast.test.com
FROM        ${REPO}/ngl525/java
MAINTAINER  NingGelin
RUN         mkdir /usr/local/SINO/demo
ADD         build/libs/demo.jar /usr/local/SINO/demo
WORKDIR     /usr/local/SINO/demo/
#CMD         ["bin/virtual-supplier", "start"]
CMD         ["java","-jar","demo.jar"]