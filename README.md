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
- ~~Preparando uma nova versão de aplicação~~
- ~~Nova revisão da definição da tarefa~~
- ~~Atualização do service com a nova revisão da tarefa~~
- ~~Monitoramento do target group das novas instâncias~~
- ~~Destruição das instâncias antigas~~
- ~~Teste 14: O trabalho do target group no processo de deployment de uma nova versão~~

### Seção 11: Criação do CRUD de produtos utilizando AWS RDS com MySQL
- ~~Arquitetura da aplicação com AWS RDS~~
- ~~Criando a instância do RDS com AWS CDK~~
- ~~Tamanho da instância do RDS~~
- ~~[OPCIONAL] Configurando a instÇancia do RDS na sub-rede pública da VPC~~
- ~~Teste 15: Vantagens da utilização do AWS RDS~~
- ~~Configurando a aplicação para acessar o Banco de Dados~~
- ~~Criando o modelo de produtos~~
- ~~Criando o repositório de produtos~~
- ~~Criando o controller de produtos~~
- ~~Teste de controller de produtos com banco de dados local~~
- ~~Criando uma nova definição de tarefas do ECS para acessar o RDS~~
- ~~Testando o CRUD de produtos~~
- ~~Tarefa 2: Adicionando um novo campo na tabela de produtos~~

### Seção 12: Publicando eventos de produtos com o AWS SNS
- ~~Arquitetura da aplicação com AWS SNS~~
- ~~Criando o tópico do SNS com AWS CDK~~
- ~~Configurando a aplicação para acessar o novo tópico~~
- ~~Criando os modelos para representar os eventos~~
- ~~Criando o serviço para publicar eventos no AWS SNS~~
- ~~Teste do publicador de eventos do SNS com LocalStack~~
- ~~Atribuindo a permissão à tarefa do ECS para acessar o SNS~~
- ~~Testando o envio de notificações pelo AWS SNS~~

### Seção 13: Publicando eventos de produtos com AWS SNS
- ~~Arquitetura da nova aplicação~~
- ~~Tarefa 3: Criando o novo projeto com o Spring Boot Initializr~~
- ~~Tarefa 4: Criando o repositório Docker Hub e preparando o projeto para gerar a imagem~~
- ~~Tarefa 5: Criando a infraestrutura da segunda aplicação com AWS CDK~~
- ~~[OPCIONAL] - Definindo um IP público para a instância da aplicação~~
- ~~Verificando a infraestrutura da aplicação~~
- ~~Teste 16: Application Load Balancer e target groups~~
- ~~Teste 17: Vantagens e desvantagens de se ter apenas um Application Load Balancer~~

### Seção 14: Construindo os eventos de produtos com AWS SQS
- ~~Arquitetura da aplicação com AWS SQS~~
- ~~Criando a nova fila e inscrevendo-a no tópico com AWS CDK~~
- ~~Desabilitando o acesso criptografados à fila do SQS~~
- ~~Configurando a aplicação para acessar a nova fila~~
- ~~Criando os modelos que representam os eventos~~
- ~~Consumindo os eventos de produso do AWS SQS com JMS~~
- ~~Teste do consumidor do SQS com LocalStack~~
- ~~Atribuindo a permissão à tarefa do ECS para acessar a fila através do AWS CDK~~
- ~~Testando o consumidor de eventos de produtos~~
- ~~Entendendo as métricas e gráficos de SQS~~
- ~~Tarefa 6: Rastreando os logs entre as duas aplicações~~

### Seção 15: Persistindo os eventos de produtos no DynamoDB
- ~~Arquitetura da aplicação com AWS DynamoDB~~
- ~~Criando a tabela do DynamoDB com AWS CDK~~
- ~~Configurando a aplicação para acessar a tabela no DynamoDB~~
- ~~Criando o modelo de evento de produto~~
- ~~Criando o repositório de evento de produto~~
- ~~Persistindo os eventos de produtos~~
- ~~Atribuindo a permissão à tarefa do ECS para acessar a tabela do DynamoDB~~
- ~~Visualizando os eventos de produtos no console do DynamoDB~~
- ~~Entendendo as métricas e gráficos do DynamoDB~~
- ~~Teste 18: Tabelas do DynamoDB~~

### Seção 16: Criando um controller para buscar os eventos de produtos
- Criando o novo controller
- Buscando eventos pelo código do produto e tipo
- Teste local do DynamoDB com LocalStack
- Testando o novo controller com o Postman
- Teste 7: Adicionando o messageId na tabela de eventos do DynamoDB

### Seção 17: Preparando para os testes de carga
- Criando a coleção no Postman
- Executando o teste de carga
- Verificando os gráficos de consumo de recursos
- Analisando os gráficos do DynamoDB

### Seção 18: Configurando o auto scaling da tabela do DynamoDB com AWS CDK
- Alterando as configurações da tabela do DDB para ligar o autoscaling
- Gerando tráfego para testar o autoscaling da tabela do DDB
- Analisando os gráficos e métricas da tabela do DDB

### Seção 19: Configurando a tabela do DynamoDB para on demand
- Alterando a tabela do DynamoDB para on demand
- Repetindo o teste de carga
- Analisando os gráficos de consumo de capacidades do DynamoDB
 
### Seção 20: Importando arquivos com o AWS S3
- O que é o AWS Simple Storage Service S3?
- Arquitetura da aplicação com AWS S3
- Criando o bucket no S3, SNS e SQS com o AWS CDK
- Configurando a aplicação para acessar o bucket
- Configurando a aplicação para acessar o SQS
- Criando o modelo para solicitar a URL pré-assinada
- Criando o controller para solicitar para a URL pré-assinada
- Criando os modelos para importar os arquivos
- Criando o consumidor de eventos do S3
- Criando as operações de pesquisa de notas fiscais
- Teste local

### Seção 21: Conclusão
- ~~Conclusão~~