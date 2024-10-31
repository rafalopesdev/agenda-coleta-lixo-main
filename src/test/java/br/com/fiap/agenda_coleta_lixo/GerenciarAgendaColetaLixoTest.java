package br.com.fiap.agenda_coleta_lixo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber-reports/report.json",
                "html:target/cucumber-reports/report.html"
        },
        features = "src/test/resources/features",
        glue = "br.com.fiap.agenda_coleta_lixo"
)
public class GerenciarAgendaColetaLixoTest {
}



