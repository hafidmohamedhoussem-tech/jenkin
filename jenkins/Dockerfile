FROM docker:cli AS dockercli
FROM jenkins/jenkins:lts-jdk17
USER root
COPY --from=dockercli /usr/local/bin/docker /usr/local/bin/docker
RUN apt-get update && apt-get install -y --no-install-recommends git curl && rm -rf /var/lib/apt/lists/* \
    && git config --global protocol.file.allow always \
    && git config --global --add safe.directory '*'
RUN jenkins-plugin-cli --plugins workflow-aggregator git
COPY jenkins/init.groovy.d/create-job.groovy /usr/share/jenkins/ref/init.groovy.d/create-job.groovy
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
