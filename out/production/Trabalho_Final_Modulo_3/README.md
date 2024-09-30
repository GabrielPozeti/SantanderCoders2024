# Trabalho Final Módulo 3 - Locadora de Veículos

## Descrição do Projeto
Este projeto é baseado na tentativa de implementação de um software de gerenciamento para locadoras de veículos.

O sistema permite cadastrar clientes, veículos e agências, além de realizar locações e devoluções de veículos.

## Funcionalidades
- Cadastro de clientes (Pessoa Física e Pessoa Jurídica)
- Cadastro de veículos (Carro, Moto e Caminhão)
- Cadastro de agências
- Locação e devolução de veículos
- Listagem de clientes, veículos e agências

## Estrutura do Projeto
A estrutura do projeto é composta pelas seguintes classes:

- **Cliente**
    - Classe base para Clientes, contendo atributos e métodos comuns.

- **ClientePF**
    - Extensão da classe Cliente, representando um cliente do tipo Pessoa Física.

- **ClientePJ**
    - Extensão da classe Cliente, representando um cliente do tipo Pessoa Jurídica.

- **Veiculo**
    - Classe base para veículos, contendo atributos e métodos comuns.

- **Carro**, **Moto**, **Caminhao**
    - Extensões da classe Veiculo que herdam suas caracteristicas, representando tipos específicos de veículos.

- **Agencia**
    - Representa uma agência de locação de veículos.

- **Locacao**
    - Representa uma locação de veículo, associando um cliente a um veículo.

- **Sistema**
    - Classe responsável por gerenciar todas as operações do sistema, incluindo cadastro e busca de clientes, veículos e agências.

- **Main**
    - Classe principal que contém o método `main` e o menu interativo da aplicação.