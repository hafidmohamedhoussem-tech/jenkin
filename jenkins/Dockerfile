FROM docker:cli AS dockercli
FROM jenkins/jenkins:lts-jdk17
USER 0:0
RUN jenkins-plugin-cli --plugins workflow-aggregator git
COPY --from=dockercli /usr/local/bin/docker /usr/local/bin/docker
COPY jenkins/init.groovy.d/create-job.groovy /usr/share/jenkins/ref/init.groovy.d/create-job.groovy
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
