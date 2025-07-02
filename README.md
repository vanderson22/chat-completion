# Chat Completion IA - Spring Boot

Projeto de demonstração de uma API de chat com IA utilizando Spring Boot e integração com modelos OpenAI via Spring AI.

## Funcionalidades
- Geração de respostas de IA via endpoint REST
- Geração de receitas personalizadas com base em ingredientes, instruções e restrições alimentares

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.5.3
- Spring AI (OpenAI)
- Maven

## Como rodar o projeto

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repositorio>
   cd MCP_SPRING/chat-completion/chat
   ```

2. **Configure a chave da OpenAI:**
   - Crie um arquivo `.env` ou defina a variável de ambiente `OPEN_AI_API_KEY` com sua chave da OpenAI.
   - Ou edite `src/main/resources/application-dev.properties`:
     ```properties
     spring.ai.openai.api-key=SEU_API_KEY_AQUI
     ```

3. **Build e execução:**
   ```bash
   ./mvnw spring-boot:run
   # ou
   mvn spring-boot:run
   ```
   O serviço estará disponível em `http://localhost:8080`.

## Endpoints Disponíveis

### 1. Chat IA Simples
- **GET** `/chat/ai?param=mensagem`
  - Retorna uma resposta da IA para o texto enviado em `param`.

### 2. Chat IA com Opções
- **GET** `/chat/ai/options?param=mensagem`
  - Retorna uma resposta da IA usando modelo e parâmetros customizados (gpt-4o, temperatura, etc).

### 3. Gerar Receita
- **POST** `/recipes`
  - Gera uma receita personalizada.
  - **Body JSON:**
    ```json
    {
      "ingredients": "frango, arroz, cenoura",
      "instructions": "assar o frango, cozinhar o arroz, misturar tudo",
      "dietaryRestrictions": "sem glúten"
    }
    ```
  - **Resposta:** Texto da receita gerada pela IA.

## Estrutura do Projeto
```
chat-completion/
  chat/
    src/
      main/
        java/br/com/home/ia/chat/
          controller/         # Controllers REST
          models/             # Modelos de dados
          services/           # Serviços de negócio/IA
        resources/
          application.properties
          application-dev.properties
    pom.xml
    mvnw, mvnw.cmd           # Scripts Maven Wrapper
```

## Configuração
- A chave da OpenAI é obrigatória para funcionamento dos endpoints de IA.
- O perfil padrão é `dev`.

## Build do Projeto
- Para gerar o JAR:
  ```bash
  ./mvnw clean package
  # ou
  mvn clean package
  ```
  O artefato será gerado em `target/chat-0.0.1-SNAPSHOT.jar`.

## Testes
- (Adicione instruções aqui caso existam testes automatizados)

## Referências
- [Spring AI](https://docs.spring.io/spring-ai/reference/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [OpenAI](https://platform.openai.com/docs/api-reference)

---

> Projeto de estudo e demonstração de integração de IA generativa com Spring Boot.
