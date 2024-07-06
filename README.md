# Mini Curso Spring Boot - 1ª Jornada de Engenharia de Software da UEPA

Este projeto foi desenvolvido durante a 1ª Jornada de Engenharia de Software da Universidade do Estado do Pará (UEPA) utilizando Spring Boot e PostgreSQL.
Descrição do Projeto

 O objetivo deste projeto é demonstrar a criação de uma API RESTful para gerenciamento de alunos e matérias. A aplicação foi desenvolvida com as seguintes tecnologias:

- Java 17
- Maven 3.9.6
- PostgreSQL 14

### Compile e execute a aplicação usando Maven:

```shell
mvn clean install
mvn spring-boot:run
```

### Importe as Collections no Postman

Para facilitar o teste da API, importe a collection do Postman. Siga os passos abaixo para importar a collection:

   - Abra o Postman.
   - Vá para o menu File e selecione Import.
   - Navegue até a pasta Collections no diretório do projeto.
   - Selecione o arquivo UEPA_Jornada_Collection.postman_collection.json e clique em Open.

### Executar Queries de Inserção

Para popular o banco de dados com dados iniciais, execute as queries de inserção localizadas na pasta resource/sqls:

 - CREATE_BD.sql (Caso não tenha o banco de dados criado ainda)
 - Insert_Alunos.sql 
 - Insert_Materias.sql

### Dúvidas ?

Me mande um email: gcristhie@hotmail.com ou entre em contato via Linkedin