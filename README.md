#  Irrigation DevOps

Aplicação Java Spring Boot para gerenciamento inteligente de zonas de irrigação, integrando práticas de DevOps como CI/CD, containerização e testes automatizados com BDD (Cucumber + JUnit).

---

#  Tecnologias Utilizadas

- Java 21 + Spring Boot 3.4
- MongoDB
- JUnit 5 + Cucumber (BDD)
- RestAssured
- Docker + Docker Compose
- GitHub Actions (CI/CD)
- Maven
- Gherkin

---

#  Estrutura do Projeto

src/
├── main/
│ └── java/com/smartcity/irrigation/ # Código-fonte
├── test/
│ ├── java/com/smartcity/steps/ # Steps BDD
│ └── resources/features/zone.feature # Cenários Gherkin
docker-compose.yml
docker-compose.staging.yml
docker-compose.production.yml
README.md
pom.xml


---

#  Como Executar os Testes Localmente

# 1. Subir o ambiente com Docker
bash

docker-compose up --build

# 2. Executar os testes automatizados

./mvnw clean test
   
# 3. Isso irá rodar os testes descritos em Gherkin e gerar evidências na pasta:

 target/surefire-reports/
 
 ---
 
#  Acessar a aplicação (após iniciar)
API Base: http://localhost:8080/zones

MongoDB: localhost:27017






 