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

# Collection

Para acessar o swagger do projeto entre no endereço:

> http://localhost:8080/swagger-ui/index.html

Exemplo do body da request de criação de uma cotação:

```json
{
	"product_id": "1b2da7cc-b367-4196-8a78-9cfeec21f587",
	"offer_id": "adc56d77-348c-4bf0-908f-22d402ee715c",
	"category": "HOME",
	"total_monthly_premium_amount": 75.25,
	"total_coverage_amount": 825000.00,
	"coverages": {
		"Incêndio": 250000.00,
		"Desastres naturais": 500000.00,
		"Responsabiliadade civil": 75000.00
	},
	"assistances": [
		"Encanador",
		"Eletricista",
		"Chaveiro 24h"
	],
	"customer": {
		"document_number": "36205578900",
		"name": "John Wick",
		"type": "NATURAL",
		"gender": "MALE",
		"date_of_birth": "1973-05-02",
		"email": "johnwick@gmail.com",
		"phone_number": 11950503030
	}
}
```
