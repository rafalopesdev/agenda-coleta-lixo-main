package br.com.fiap.agenda_coleta_lixo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"br.com.fiap.agenda_coleta_lixo.steps", "br.com.fiap.agenda_coleta_lixo.config"}, // Incluindo o pacote de steps e configuração
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class GerenciarAgendaColetaLixoTest {
}

