# Bank System – Java Core & Architecture Study

Este projeto é um **estudo prático de Java Core, POO avançado e arquitetura**, com foco em **design de domínio, princípios SOLID e mindset de engine/framework**.

O objetivo **não é usar frameworks**, mas **entender como eles funcionam por dentro**, construindo as bases manualmente.

---

## 🎯 Objetivos do Projeto

- Praticar **Java puro**
- Dominar **OOP de verdade** (não só sintaxe)
- Aplicar princípios como:
    - Encapsulamento
    - Polimorfismo
    - Open/Closed Principle
    - Dependency Inversion Principle
- Criar uma base arquitetural próxima de:
    - Frameworks backend (ex: Spring)
    - Engines de jogos
- Evoluir o projeto de forma incremental, com desafios diários

---

## 🧱 Arquitetura Atual

- **Entity**
    - `Account`
    - `Client`
    - `Transaction`

- **Contracts**
    - `AccountPolicy` (contrato de comportamento)

- **Implements**
    - `SimpleAccountPolicy`
    - `MiddleAccountPolicy`
    - `GoldAccountPolicy`

- **Enums**
    - `AccountType`
    - `TransactionType`

- **Factory**
    - `AccountPolicyFactory`

---

## 🧠 Conceitos Aplicados

- Separação de responsabilidades
- Regras de negócio isoladas em políticas
- Uso de interfaces para desacoplamento
- Fábrica para criação de dependências
- Histórico de transações sem dependência de banco
- Código preparado para evolução (plugins, eventos, framework)

---

## 🚀 Status

Projeto em desenvolvimento contínuo, seguindo um **plano de estudos diário**, evoluindo em direção a:
- Event system
- Observers
- Base de engine
- Mini framework
- Futuro backend semântico (Spring-like)

---

## 📌 Observação


Este projeto é **educacional**, focado em aprendizado profundo de arquitetura e Java Core.