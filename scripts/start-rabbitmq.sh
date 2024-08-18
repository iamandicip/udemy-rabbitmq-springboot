#!/bin/bash

#docker run -d --restart always \
#--hostname localhost \
#-p 5672:5672 \
#-p 15672:15672 \
#-v ~/Dev/rabbitmq/data:/var/lib/rabbitmq/mnesia \
#--name rabbit-mq-1 rabbitmq:3-management

docker run -d --restart always \
--name rabbitmq \
--hostname localhost \
-p 5672:5672 \
-p 15672:15672 \
-p 5552:5552 \
-v ~/Dev/rabbitmq/data:/var/lib/rabbitmq/mnesia \
-e RABBITMQ_SERVER_ADDITIONAL_ERL_ARGS="-rabbitmq_stream advertised_host localhost" \
rabbitmq:3-management

