# Empresa CRUD

Este projeto é uma aplicação CRUD (Create, Read, Update, Delete) para gerenciamento de Clientes, Fornecedores, Funcionários, Produtos e Armazéns. Utiliza Spring Boot para a implementação do backend e JPA para a persistência de dados.

## Estrutura do Projeto

- **Modelo:** Define as entidades do sistema (`Cliente`, `Fornecedor`, `Funcionario`, `Produto`, `Armazem`).
- **Repositório:** Interface JPA para operações de banco de dados.
- **Serviço:** Contém a lógica de negócio.
- **Controlador:** Exponha endpoints REST para interações com o frontend ou outros sistemas.

## Dependências

O projeto utiliza as seguintes dependências principais:

- `Spring Boot` (versão 2.7.1): Framework para criação de aplicações Spring autossuficientes.
- `Spring Data JPA`: Facilita a implementação de repositórios baseados em JPA.
- `H2 Database`: Banco de dados em memória para testes e desenvolvimento.
- `Spring Boot Starter Test`: Inclui bibliotecas necessárias para testes de unidade e integração.

