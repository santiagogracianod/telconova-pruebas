package co.udea.certificacion.moduloseguimientodeordenes.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/orders/order_materials.feature",
    glue     = "co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions",
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class MaterialsRunner {

}
