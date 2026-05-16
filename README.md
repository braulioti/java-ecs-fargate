# Crie a infraestrutura de microsserviços Spring Boot em cluster com AWS CDK, usando ECS, SNS, SQS, RDS, DynamoDB e S3.

### Seção 1: Introdução
- ~~Conteúdo do Curso~~
- ~~Conceitos iniciais de AWS~~
- ~~Preparação do ambiente~~
- ~~[OPCIONAL] Criação do alarme de cobrança~~

### Seção 2: Conceitos de Spring Boot
- ~~[OBRIGATÓRIO] Atualização de versões de bibliotecas~~
- ~~Criando o primeiro projeto~~
- ~~Projeto base com versão definida do Java e do Spring Boot~~
- ~~Abrindo o projeto no IntelliJ IDEA~~
- ~~Criando o primeiro endpoint REST~~
- ~~Teste 1: Anotações para criar um controller e um endpoint~~
- ~~Teste 2: Parâmetros e retornos de uma operação~~

### Seção 3: Executando a aplicação em um container Docker
- ~~Visão geral do Docker~~
- ~~Criando o repositório no Docker Hub~~
- ~~Preparando o projeto para gerar a imagem Docker~~
- ~~Executando a aplicação em container Docker no IntelliJ IDEA~~

### Seção 4: Introdução ao AWS CloudFormation
- ~~Introdução ao AWS CloudFormation~~
- ~~Analisando stacks, eventos, recursos e parâmetros~~
- ~~Teste 3: Stacks~~
- ~~Apagando uma stack~~
- ~~Teste 4: Excluindo uma stack~~

### Seção 5: Introdução ao AWS CDK
- ~~Criação do usuário IAM para o AWS CDK~~
- ~~[OBRIGATÓRIO] - Migração para o AWS CDK 2.x~~
- ~~Instalação do AWS CDK~~
- ~~Criando o projeto com CDK~~
- ~~Entendendo a estrutura do projeto com CDK~~
- ~~Teste 5: AWS CDK~~

### Seção 6: Introdução ao AWS ECS com Fargate
- ~~Arquitetura com AWS ECS e Fargate~~
- ~~VPC - Virtual Private Cloud~~
- ~~Cluster~~
- ~~Teste 6: AWS ECS com Fargate~~
- ~~Task e Task Definition~~
- ~~Teste 7: Task e Task Definition do AWS ECS~~
- ~~Service~~
- ~~Teste 8: Gerenciamento das instâncias pelo Serviço~~
- ~~Auto Scaling~~
- ~~Teste 9: Sobre o auto-scaling~~
- ~~ALB - Application load balancer, target group e security group~~
- ~~Teste 10: Application Load Balancer~~

### Seção 7: Deployment da aplicação no ECS com Fargate
- ~~Criação da stack na VPC~~
- ~~[OPCIONAL] Reduzindo custos na criação da VPC~~
- ~~Criação da stack do cluster com AWS CDK~~
- ~~Criação do application load balancer e demais recursos~~
- ~~[OPCIONAL] Definindo um IP público para a aplicação~~
- ~~Configuração do target group~~
- ~~Criação das regras de auto scaling~~
- ~~Deployment dos recursos com AWS CDK~~
- ~~Sobre as cobranças na conta da AWS~~
- ~~Analisando as stack criadas no AWS CloudFormation~~
- ~~Teste 11: Stacks e suas dependências~~

### Seção 8: Monitorando o serviço criado no AWS ECS
- ~~Gráficos de CPU e memória~~
- ~~Definição da tarefa~~
- ~~Service~~
- ~~Logs da aplicação no CloudWatch Insights~~
- ~~Teste 12: Vantagens do CloudWatch Insights~~
- ~~Criando e executando uma nova versão da aplicação~~
- ~~Tarefa 1: Criando e executando uma nova versão da aplicação~~
- ~~[OPCIONAL] Destruindo os recursos criados~~

### Seção 9: Monitorando o Application Load Balancer
- ~~Console do Application Load Balancer e suas métricas~~
- ~~Target Group e o Health Check~~
- ~~Security Group e as regras de segurança~~
- ~~Teste 13: Monitoramento da aplicação pelo ALB e target group~~

### Seção 10: Como funciona o processo de deployment de uma nova versão de aplicação
- Preparando uma nova versão de aplicação
- Nova revisão da definição da tarefa
- Atualização do service com a nova revisão da tarefa
- Monitoramento do target group das novas instâncias
- Destruição das instâncias antigas
- Teste 14: O trabalho do target group no processo de deployment de uma nova versão

### Seção 11: Criação do CRUD de produtos utilizando AWS RDS com MySQL
- Arquitetura da aplicação com AWS RDS
- Criando a instância do RDS com AWS CDK
- Tamanho da instância do RDS
- [OPCIONAL] Configurando a instÇancia do RDS na sub-rede pública da VPC
- Teste 15: Vantagens da utilização do AWS RDS
- Configurando a aplicação para acessar o Banco de Dados
- Criando o modelo de produtos
- Criando o repositório de produtos
- Criando o controller de produtos
- Teste de controller de produtos com banco de dados local
- Criando uma nova definição de tarefas do ECS para acessar o RDS
- Testando o CRUD de produtos
- Tarefa 2: Adicionando um novo campo na tabela de produtos