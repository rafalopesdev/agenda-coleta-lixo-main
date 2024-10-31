package br.com.fiap.agenda_coleta_lixo.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"br.com.fiap.agenda_coleta_lixo.steps", "br.com.fiap.agenda_coleta_lixo.config"},
        plugin = {"html:target/cucumber-reports/report.html"} // Modifique para um arquivo específico
)
public class TestRunner {
}

