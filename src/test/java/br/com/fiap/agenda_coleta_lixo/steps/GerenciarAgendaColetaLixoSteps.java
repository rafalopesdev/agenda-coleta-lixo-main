package br.com.fiap.agenda_coleta_lixo.steps;

import br.com.fiap.agenda_coleta_lixo.model.LixoModel;
import br.com.fiap.agenda_coleta_lixo.service.LixoService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GerenciarAgendaColetaLixoSteps {

    private Map<String, String> dadosColeta;
    private Response response;
    private String id;
    private String tipo, dia, horario, endereco;

    @Autowired
    private LixoService lixoService;

    // POST
    @Dado("que eu tenho os dados completos de um novo registro de coleta")
    public void queEuTenhoOsDadosCompletosDeUmNovoRegistroDeColeta(DataTable dataTable) {
        dadosColeta = new HashMap<>();
        List<Map<String, String>> listaDados = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> linha : listaDados) {
            dadosColeta.put("tipo", linha.get("tipo"));
            dadosColeta.put("dia", linha.get("dia"));
            dadosColeta.put("horario", linha.get("horario"));
            dadosColeta.put("endereco", linha.get("endereco"));
        }
    }

    @Quando("eu envio uma requisição POST para criar o registro completo")
    public void euEnvioUmaRequisicaoPOSTParaCriarORegistroCompleto() {
        LixoModel lixo = new LixoModel(dadosColeta.get("tipo"), dadosColeta.get("dia"), dadosColeta.get("horario"), dadosColeta.get("endereco"));

        response = RestAssured
                .given()
                .contentType("application/json")
                .body(lixo)
                .post("/api/lixo");
    }

    @Então("o registro completo deve ser criado com sucesso e o status code deve ser {int}")
    public void oRegistroCompletoDeveSerCriadoComSucessoEStatusCode(int statusCodeEsperado) {
        Assert.assertEquals(statusCodeEsperado, response.getStatusCode());
    }

    // POST
    @Dado("que eu tenho os dados de um novo registro de coleta")
    public void que_eu_tenho_os_dados_de_um_novo_registro_de_coleta(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> dados = dataTable.asMaps(String.class, String.class);
        Map<String, String> linhaDeDados = dados.get(0);

        this.tipo = linhaDeDados.get("tipo");
        this.dia = linhaDeDados.get("dia");
        this.horario = linhaDeDados.get("horario");
        this.endereco = linhaDeDados.get("endereco");
    }

    @Quando("eu envio uma requisição POST para criar o registro")
    public void eu_envio_uma_requisicao_post_para_criar_o_registro() {
        LixoModel lixoModel = new LixoModel(tipo, dia, horario, endereco);
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(lixoModel)
                .post("/api/lixo");
    }

    @Então("o registro deve ser criado com sucesso e o status code deve ser {int}")
    public void o_registro_deve_ser_criado_com_sucesso_e_o_status_code_deve_ser(Integer statusCodeEsperado) {
        response.then().statusCode(statusCodeEsperado);
    }

    // GET
    @Dado("que existem registros de coleta cadastrados")
    public void queExistemRegistrosDeColetaCadastrados() {
        LixoModel lixo1 = new LixoModel("Orgânico", "2024-10-15", "07:00", "Rua Principal, 123");
        LixoModel lixo2 = new LixoModel("Reciclável", "2024-10-16", "08:00", "Rua Secundária, 456");

        lixoService.createLixo(lixo1);
        lixoService.createLixo(lixo2);
    }

    @Quando("eu envio uma requisição GET para listar todos os registros")
    public void euEnvioUmaRequisicaoGETParaListarTodosOsRegistros() {
        response = RestAssured.given()
                .when()
                .get("/api/lixo")
                .then()
                .extract()
                .response();
    }

    @Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCodeEsperado) {
        assertEquals(statusCodeEsperado, response.getStatusCode());
    }

    @Então("a resposta deve conter uma lista de registros de coleta")
    public void aRespostaDeveConterUmaListaDeRegistrosDeColeta() {
        List<LixoModel> registros = response.jsonPath().getList(".", LixoModel.class);
        Assert.assertFalse(registros.isEmpty());
        for (LixoModel registro : registros) {
            Assert.assertNotNull(registro.getTipo());
            Assert.assertNotNull(registro.getDia());
            Assert.assertNotNull(registro.getHorario());
            Assert.assertNotNull(registro.getEndereco());
        }
    }

    // DELETE
    @Dado("que existe um registro de coleta com o ID {string}")
    public void queExisteUmRegistroDeColetaComOID(String id) {
        LixoModel lixo = new LixoModel("Orgânico", "2024-10-15", "07:00", "Rua Principal, 123");
        lixo.setId(id);
        lixoService.createLixo(lixo);
    }

    @Quando("eu envio uma requisição DELETE para deletar o registro com o ID {string}")
    public void euEnvioUmaRequisicaoDELETEParaDeletarORegistroComOID(String id) {
        response = RestAssured.given()
                .when()
                .delete("/api/lixo/" + id)
                .then()
                .extract()
                .response();
    }

    @Então("o registro com o ID {string} não deve mais existir")
    public void oRegistroComOIDNaoDeveMaisExistir(String id) {
        Optional<LixoModel> lixo = lixoService.getLixoById(id);
        Assert.assertFalse(lixo.isPresent());
    }

    // PUT
    @Dado("que existe um registro de coleta cadastrado para atualização")
    public void queExisteUmRegistroDeColetaCadastradoParaAtualizacao() {
        LixoModel lixo = new LixoModel("Orgânico", "2024-10-15", "07:00", "Rua Principal, 123");
        LixoModel registroCriado = lixoService.createLixo(lixo);
        id = registroCriado.getId();
    }

    @Quando("eu envio uma requisição PUT para atualizar o registro")
    public void euEnvioUmaRequisicaoPUTParaAtualizarORegistro() {
        LixoModel lixoAtualizado = new LixoModel("Reciclável", "2024-10-15", "07:00", "Rua Atualizada, 456");

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(lixoAtualizado)
                .when()
                .put("/api/lixo/" + id)
                .then()
                .extract()
                .response();
    }

    @Então("o campo {string} do registro atualizado deve ser {string}")
    public void oCampoDoRegistroAtualizadoDeveSer(String campo, String valorEsperado) {
        String valorAtual = response.jsonPath().getString(campo);
        Assert.assertEquals(valorEsperado, valorAtual);
    }

    @Então("o campo {string} do registro criado deve ser {string}")
    public void o_campo_do_registro_criado_deve_ser(String campo, String valorEsperado) {
        String valorAtual = response.jsonPath().getString(campo);
        Assert.assertEquals(valorEsperado, valorAtual);
    }

    @Então("o status code deve ser {int}")
    public void o_status_code_deve_ser(Integer statusCodeEsperado) {
        Assert.assertEquals(statusCodeEsperado.intValue(), response.getStatusCode());
    }

}
