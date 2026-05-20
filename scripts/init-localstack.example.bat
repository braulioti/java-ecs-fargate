@echo off
set ENDPOINT=http://localhost:4566
set AWS_ACCESS_KEY_ID=
set AWS_SECRET_ACCESS_KEY=
set LOCALSTACK_AUTH_TOKEN=
set AWS_DEFAULT_REGION=us-east-1

aws --endpoint-url=%ENDPOINT% sns create-topic --name product-events
