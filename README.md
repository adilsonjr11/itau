# Objetivo

Este projeto é a implementação de um desafio onde é necessário
receber uma cotação, validar produto e oferta requisitando outro serviço, 
persistir, enviar para outro serviço que gera apólice via mensageria e
tambem por mensageria receber a apólice gerada e atualizar a cotação.
Adicionalmente, expor um endpoint para consulta.

# Tecnologias / patterns

* JDK-17
* Kotlin
* Gradlew
* Spring boot
* H2 (embarcado)
* Artemis (embarcado)
* Hexagonal arch / Clean arch

> Optei por tecnologias embarcadas por uma questão de facilidade,
> sendo assim não se faz necessário dockerfile / docker-compose como
> requisito para subir o projeto.

> Por uma questão de desacoplamento optei por uma estrutura baseada
> em hexagonal arch / clean arch.

> Criei 2 filas no Artemis:
> * insurance-quote-received
> * insurance-policy-created
> 
> Não deu tempo de terminar a implementação, mas elas podem ser chamadas
> e lidas por:
> * ```jmsTemplate.convertAndSend(queueName, msg)```
> * ```@JmsListener(queueName)```
