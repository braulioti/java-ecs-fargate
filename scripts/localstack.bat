@echo off
setlocal

set CONTAINER_NAME=localstack-main

docker ps -a --filter "name=%CONTAINER_NAME%" --format "{{.Names}}" | findstr /x "%CONTAINER_NAME%" >nul
if %errorlevel%==0 (
  echo Container %CONTAINER_NAME% ja existe. Iniciando...
  docker start %CONTAINER_NAME%
  goto :wait_ready
)

echo Subindo LocalStack ^(imagem 3.x, sem token^)...
docker run -d --name %CONTAINER_NAME% ^
  -p 4566:4566 -p 4510-4559:4510-4559 ^
  -e SERVICES=sns,sqs,dynamodb,s3 ^
  localstack/localstack:3

:wait_ready
echo Aguardando LocalStack em http://localhost:4566 ...
set /a RETRIES=0
:wait_loop
curl.exe -sf http://localhost:4566/_localstack/health >nul 2>&1
if %errorlevel%==0 goto :ready
set /a RETRIES+=1
if %RETRIES% GEQ 30 (
  echo.
  echo ERRO: LocalStack nao respondeu apos 60s.
  echo Verifique: docker logs %CONTAINER_NAME%
  exit /b 1
)
ping -n 3 127.0.0.1 >nul
goto :wait_loop

:ready
echo LocalStack pronto. Rode scripts\init-localstack.bat em outro terminal.
endlocal
