# 🦆 Granja de Patos - Sistema de Vendas "Preço Justo"

Este projeto consiste no desenvolvimento de uma API REST para o gerenciamento de uma granja de patos.  
O sistema permite o cadastro de patos com rastreamento de linhagem (mãe), gestão de clientes e vendedores, registro de vendas com aplicação automática de descontos e geração de relatórios em Excel, conforme as regras definidas no desafio.

---

## 🛠️ Tecnologias Utilizadas
- Java 21
- Spring Boot 3.2.x
- JPA / Hibernate
- PostgreSQL
- Flyway
- Apache POI
- Docker
- Maven
- JUnit (testes unitários)




## 📌 Funcionalidades

-Cadastro de patos, clientes e vendedores

-Venda de patos com validações de negócio

-Aplicação automática de desconto para clientes elegíveis

-Geração de relatórios em Excel

-Ranking de vendedores

-Testes unitários das principais regras



 ## 📋 Regras de Negócio

-Cada pato é cadastrado individualmente

-Um pato pode ter uma mãe cadastrada

-Um pato só pode ser vendido uma única vez

-O valor do pato varia conforme a quantidade de filhos

-Clientes com desconto recebem 20% de abatimento no valor da venda


---

## ▶️ Como Executar o Projeto

```bash
docker-compose up -d
mvn clean install
mvn spring-boot:run

A aplicação estará disponível em:
http://localhost:8080
```

