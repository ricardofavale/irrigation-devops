package com.smartcity.steps;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class ZoneSteps {

    private Response response;
    private String baseUrl = "http://localhost:8080";

    @Dado("que o sistema está em execução")
    public void sistemaRodando() {
        baseURI = baseUrl;
    }

    @Quando("eu envio uma requisição POST para {string} com o corpo:")
    public void requisicaoPost(String endpoint, String corpoJson) {
        response = given()
                .header("Content-Type", "application/json")
                .body(corpoJson)
                .when()
                .post(endpoint);
    }

    @Então("o status da resposta deve ser {int}")
    public void verificarStatus(int statusEsperado) {
        response.then().statusCode(statusEsperado);
    }

    @E("o corpo da resposta deve conter {string}")
    public void corpoContem(String valorEsperado) {
        response.then().body("name", equalTo(valorEsperado));
    }

    @Quando("eu envio uma requisição GET para {string}")
    public void requisicaoGet(String endpoint) {
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .get(endpoint);
    }

    @Então("a resposta deve conter uma lista de zonas")
    public void verificarLista() {
        response.then().statusCode(200)
                .body("$", not(empty()));
    }

    @Quando("eu envio uma requisição POST inválida para {string} com o corpo:")
    public void requisicaoPostInvalida(String endpoint, String corpoInvalido) {
        response = given()
                .header("Content-Type", "application/json")
                .body(corpoInvalido)
                .when()
                .post(endpoint);
    }

    @E("o corpo deve seguir o schema da zona")
    public void validar_schema() {
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath("schema/zone-schema.json"));
    }

}


