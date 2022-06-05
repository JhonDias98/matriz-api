# Matriz API
A api tem como finalidade receber umar lista de números inteiros, converter para uma matriz quadrada, rotacionar uma vez para direita e retornar a lista com os valores rotacionados.

## Execução: 

Clone o repositório e importe em sua IDEA preferida ou execute algum dos comandos abaixo na raiz do repositório no terminal.

**Aplicação:** mvn spring-boot:run

**Testes:** mvn test

## Swagger
Após executar a aplicação, [clique aqui](http://localhost:8080/swagger-ui/index.html) para acessar a interface do swagger.


## Completude
**O programa resolve todos os casos, incluindo diferentes números de linhas e colunas, tabelas grandes e pequenas e casos de erro?**

**Resposta:** sim, em qualquer caso que a lista não for válida(1x1, 2x2, 3x3, 4x4...), vai ser retornado uma lista vazia com um boolean false.

**Para os casos tratados, estão sendo tratados corretamente?**

**Resposta:** Sim

**Como você sabe disso?**
**Resposta:** Fiz vários testes manuais com listas inválidas e válidas, como 4x4 e 5x5, em todos os casos, tive o resultado esperado. 

**Você fez testes usando algum exemplo de dados? Se sim, por favor inclua isso no seu código.**

**Resposta:** os dados que utilizei para testes, estão no diretório: br.com.matriz.fixture.

**Você escreveu teste unitário?**

**Resposta:** Sim, cobertura dos testes acima de 90%