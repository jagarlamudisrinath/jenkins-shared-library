FROM jenkins/jenkins:lts

USER root

# Install yq
RUN curl -sL https://github.com/mikefarah/yq/releases/download/v4.6.3/yq_linux_amd64 -o /usr/bin/yq && \
    chmod +x /usr/bin/yq

USER jenkins
