# API de Produto desenvolvida em Kotlin

Descrição curta do que faz o seu projeto.

Esta API permite a manipulação de informações sobre produtos, incluindo operações como a obtenção de detalhes de um produto específico,  a criação de um novo produto,  a atualização de um produto existente, e a exclusão de um produto.

<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
     <a alt="Kotlin">
        <img src="https://img.shields.io/badge/Kotlin-1.9.22-purple.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v3.2.2-brightgreen.svg" />
    </a>
    <a alt="Gradle">
        <img src="https://img.shields.io/badge/Gradle-v7.6-lightgreen.svg" />
    </a>
    <a alt="H2">
        <img src="https://img.shields.io/badge/H2-v2.2.224-darkblue.svg" />
    </a>
</p>

## Configuração

Essas instruções fornecerão aos usuários as etapas necessárias para clonar o repositório e iniciar a aplicação em
diferentes ambientes (Unix e Windows) com o perfil de desenvolvimento ativado.

Clone o repositório: git clone `https://github.com/samuel-prazeres-junior/api-produto-kotlin.git`



2. **Execute a aplicação usando o Gradle Wrapper:**

    ```bash
    ./gradlew bootRun
    ```

   Ou usando o Gradle instalado globalmente:

    ```bash
    gradle bootRun
    ```

3. **Acesse a API em [http://localhost:8080](http://localhost:8080)**

## Endpoints

- Descreva aqui os principais endpoints da sua API, como exemplos:
    - `GET /api/product/id`: Retorna um produto específico.
    - `GET /api/product?search=mouse`: Retorna todos os produtos que contenham "mouse".
    - `POST /api/product`: Cria um novo produto.
    - `PUT /api/product/id`: Atualiza um produto específico.
    - `DELETE /api/product`: Deleta um produto.

## Documentação da API

- A documentação da API é gerada automaticamente usando o Swagger. Acesse a documentação interativa em [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
