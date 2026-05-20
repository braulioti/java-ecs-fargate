@echo off
if "%LOCALSTACK_AUTH_TOKEN%"=="" (
  echo.
  echo ERRO: LOCALSTACK_AUTH_TOKEN nao definido.
  echo.
  echo 1. Crie conta gratuita em https://app.localstack.cloud
  echo 2. Copie o Developer Auth Token em Workspace ^> Auth Tokens
  echo 3. No PowerShell, antes de rodar este script:
  echo    $env:LOCALSTACK_AUTH_TOKEN = "seu-token-aqui"
  echo.
  echo Alternativa sem token: use scripts\localstack.bat ^(imagem 3.x^)
  echo.
  exit /b 1
)

docker run --rm -p 4566:4566 -p 4510-4559:4510-4559 ^
  -e SERVICES=sns,sqs,dynamodb,s3 ^
  -e LOCALSTACK_AUTH_TOKEN=%LOCALSTACK_AUTH_TOKEN% ^
  localstack/localstack
