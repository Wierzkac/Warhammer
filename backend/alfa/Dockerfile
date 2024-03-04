# Use an official base image with your desired OS
FROM ubuntu:bionic

ENV RUNNER_ALLOW_RUNASROOT=1

# Install dependencies
RUN apt-get update
RUN apt-get install -y curl
RUN apt-get install -y libicu-dev
RUN apt-get clean
RUN rm -rf /var/lib/apt/lists/*

# Download and configure GitHub Actions runner
RUN mkdir actions-runner
RUN cd actions-runner

ARG RUNNER_VERSION=2.283.3
RUN curl -O -L https://github.com/actions/runner/releases/download/v${RUNNER_VERSION}/actions-runner-linux-x64-${RUNNER_VERSION}.tar.gz
RUN tar xzf ./actions-runner-linux-x64-${RUNNER_VERSION}.tar.gz

ARG TOKEN=not-set
RUN ./config.sh --url https://github.com/Wierzkac/Warhammer --token $TOKEN --work _work --name linux --runasservice --replace

# Clean up
RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Start the runner
CMD ["./run.sh"]
