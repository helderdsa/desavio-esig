# Desafio ESIG: Gerenciador de Tarefas
## Requisitos do Desafio:

__Concluído__:

A: Criar uma aplicação Front-end utilizando Angular na versão mais recente.<br>
B: Desenvolver o backend utilizando Java 11 e Spring Boot.<br>
C: Os endpoints devem ser em REST.<br>
E: Utilizar persistência em um banco de dados PostgreSQL e persistência JPA.   <br>
H: Publicar projeto no Heroku ou em outro ambiente cloud. Apenas o backend foi pucliado na nuvem devido a dificuldades em subir o frontend para produção. Uma análise mais detalhada sobre as possíveis causas e soluções será realizada posteriormente.<br>

__Opcionais (serão implementados no futuro)__:

D: Controle de login por usuário e senha com autenticação via JWT.<br>
F: Testes de unidade.<br>
G: Documentação da API usando Swagger.<br>

__Descrição do Projeto__:

Este projeto tem como objetivo solucionar o desafio proposto pela ESIG, desenvolvendo uma aplicação web completa para gestão de tarefas. Atualmente, o backend e o frontend estão completos mas somente o back está e publicada no Railway.

__Estrutura do Projeto__:

frontend: Contém o código fonte da aplicação Angular.<br>
backend: Contém o código fonte da aplicação Spring Boot.

__Como Executar o Projeto__:

Backend:(não executar pois o código do front aponta para o projeto na nuvem)<br>
Pré-requisitos:<br>
Java 17 instalado<br>
Maven ou Gradle instalado<br>
Executar localmente:<br>
Navegar até a pasta backend.<br>
Executar o arquivo "BackendApplication.java" que se encontra em "backend\src\main\java\com\esig\helder\desafio\backend\".<br>

Frontend:<br>
Pré-requisitos:<br>
Node.js e npm (ou yarn) instalados<br>
Executar localmente:<br>
Navegar até a pasta frontend.<br>
Executar o comando npm install.<br>
Executar o comando npm start.<br>

__Próximos Passos__:

Frontend:<br>
Investigar e solucionar as dificuldades encontradas ao subir o frontend para produção no Railway.<br>
Implementar testes de unidade.<br>
Backend:<br>
Implementar a autenticação via JWT.<br>
Implementar testes de unidade.<br>
Documentar a API usando Swagger.<br>