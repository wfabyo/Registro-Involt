# Descrição da solução
## Solução
A solução proposta consiste em uma API REST que permite o cadastro de revendas, listagem das revendas cadastradas e processamento de pedidos. A API foi desenvolvida utilizando Java 21 e Spring Boot, e os dados são armazenados em um banco de dados PostgreSQL.
A API possui 2 endpoints para cadastro e listagem de revendas. 

A solução também apresenta um endpoint para processamento de pedidos, onde é possível enviar um pedido contendo a identificação do cliente e a lista dos produtos com respectivas quantidades. O pedido é processado e o valor total é calculado com base nos preços dos produtos cadastrados na base de dados.

## Observações
Para efeito o teste em questão foi desenvolvido de forma simplista com todos os endpoints dentro da mesma aplicação.
O tratamento de erros pode ser melhorado, assim como a validação dos dados de entrada:
* Para tratativa da instabilidade do provedor, poderiamos ter usado um circuit breaker, como o Hystrix, para evitar que a aplicação fique esperando uma resposta que não virá.
* Poderíamos também ter utilizado um serviço de mensageria para processar os pedidos de forma assíncrona, evitando que a aplicação fique bloqueada aguardando a resposta do provedor.

## Testes
Quanto aos testes foram desenvolvidos testes unitários para os serviços de revenda e pedido, por falta de tempo não foi possível desenvolver testes para todas as classes e testes de funcionalidade.

## Arquitetura
A aplicação foi desenvolvida seguindo a arquitetura Hexagonal, que permite a separação das responsabilidades da aplicação em camadas, melhorando a testabilidade e manutenibilidade do código.
Procurei utilizar SOLID e Clean Code para manter o código limpo e organizado.


## Endpoints Disponíveis
A seguir, alguns dos endpoints expostos pela API:

### Cadastro de Revenda:

* Endpoint: POST /api/revendas
Descrição: Realiza o cadastro de uma revenda.
Corpo de Requisição: JSON com os dados da revenda.

### Listagem de Revendas:

* Endpoint: GET /api/revendas
Descrição: Retorna a lista de revendas cadastradas.

### Processamento de Pedido:

* Endpoint: POST /api/pedidos
Descrição: Processa o pedido enviado pela revenda.
Corpo de Requisição: JSON com a identificação do cliente e a lista dos produtos com respectivas quantidades.

## Tecnologias Utilizadas
Java 21
Spring Boot
Spring Data JPA
PostgreSQL
Maven

## Execução do Projeto
Para executar o projeto, siga os passos abaixo:

``` mvn clean install ```

``` cd docker ```

``` docker-compose up -d ```

``` mvn spring-boot:run ```