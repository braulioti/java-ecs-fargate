@echo off
set ENDPOINT=http://localhost:4566
set AWS_ACCESS_KEY_ID=
set AWS_SECRET_ACCESS_KEY=
set LOCALSTACK_AUTH_TOKEN=
set AWS_DEFAULT_REGION=us-east-1


echo Verificando LocalStack em %ENDPOINT% ...
curl.exe -sf %ENDPOINT%/_localstack/health >nul 2>&1
if %errorlevel% neq 0 (
  echo.
  echo ERRO: LocalStack nao esta rodando em %ENDPOINT%
  echo.
  echo 1. Abra outro terminal
  echo 2. Execute: scripts\localstack.bat
  echo 3. Aguarde "LocalStack pronto" e rode este script novamente
  echo.
  exit /b 1
)

echo Criando topico SNS product-events...
aws --endpoint-url=%ENDPOINT% sns create-topic --name product-events

echo Criando fila SQS product-events...
aws --endpoint-url=%ENDPOINT% sqs create-queue --queue-name product-events

echo Criando fila SQS product-events-dlq...
aws --endpoint-url=%ENDPOINT% sqs create-queue --queue-name product-events-dlq

echo.
echo Recursos criados. Endpoint: %ENDPOINT%
endlocal
