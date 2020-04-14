############################################################
# Dockerfile to Deploy 
# '/var/lib/jenkins/workspace/com.calculator Build/target/calculator-1.0-SNAPSHOT.jar' 
# into 'iamdhruvp/ubuntu_18.04.3_lts-openjdk_1.8.0_242' Docker Image
############################################################

# Set the base image
FROM iamdhruvp/ubuntu_18.04.3_lts-openjdk_1.8.0_242

# File Author
MAINTAINER Dhruv_Patel

# Set Working Directory
WORKDIR /usr/local

# Copies the files from the source on the host into the container’s set destination
ADD target/calculator-1.0-SNAPSHOT.jar .

# Default container command
ENTRYPOINT ["/usr/bin/java", "-cp", "calculator-1.0-SNAPSHOT.jar", "com/calculator/Calculator"]

