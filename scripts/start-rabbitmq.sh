#!/bin/bash
docker run -d --restart always \
--hostname localhost \
-p 5672:5672 \
-p 15672:15672 \
-v ~/Dev/rabbitmq/data:/var/lib/rabbitmq/mnesia \
--name rabbit-mq-1 rabbitmq:3-management
