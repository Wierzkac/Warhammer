#!/bin/bash
cd /home/ec2-user
aws s3 cp s3://warhammer-backend-bucket/Warhammer-0.0.1-SNAPSHOT.jar .
docker-compose up -d
java -jar Warhammer-0.0.1-SNAPSHOT.jar