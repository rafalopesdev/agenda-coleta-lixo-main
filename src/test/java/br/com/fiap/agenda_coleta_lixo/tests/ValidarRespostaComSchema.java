package br.com.fiap.agenda_coleta_lixo.tests;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidarRespostaComSchema {
    @Test
    public void validarRespostaDeRegistroComSchema() {
        Response response = given()
                .get("/api/lixo") // Altere o endpoint conforme necessário
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/respostaSchema.json"))
                .extract()
                .response();

        // Outras validações adicionais, se necessário
        response.then().body("tipo", equalTo("Orgânico")); // Exemplo de verificação de campo
    }
}
