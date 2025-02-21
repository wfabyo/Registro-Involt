# Endpoints Disponíveis
A seguir, alguns dos endpoints expostos pela API:

## Cadastro de Revenda:

* Endpoint: POST /api/revendas
Descrição: Realiza o cadastro de uma revenda.
Corpo de Requisição: JSON com os dados da revenda.

## Listagem de Revendas:

* Endpoint: GET /api/revendas
Descrição: Retorna a lista de revendas cadastradas.

## Processamento de Pedido:

* Endpoint: POST /api/pedidos
Descrição: Processa o pedido enviado pela revenda.
Corpo de Requisição: JSON com a identificação do cliente e a lista dos produtos com respectivas quantidades.

# Tecnologias Utilizadas
Java 21
Spring Boot
Spring Data JPA
PostgreSQL
Maven

# Execução do Projeto
Para executar o projeto, siga os passos abaixo:

``` mvn clean install ```

``` cd docker ```

``` docker-compose up -d ```

``` mvn spring-boot:run ```