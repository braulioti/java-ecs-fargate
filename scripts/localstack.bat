@echo off
REM LocalStack 4+ exige LOCALSTACK_AUTH_TOKEN (gratis em https://app.localstack.cloud).
REM A imagem 3.x abaixo funciona sem token para desenvolvimento local.
docker run --rm -p 4566:4566 -p 4510-4559:4510-4559 ^
  -e SERVICES=sns,sqs,dynamodb,s3 ^
  localstack/localstack:3
