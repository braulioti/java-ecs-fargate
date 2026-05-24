@echo off
docker stop localstack-main 2>nul
docker rm localstack-main 2>nul
echo LocalStack encerrado.
