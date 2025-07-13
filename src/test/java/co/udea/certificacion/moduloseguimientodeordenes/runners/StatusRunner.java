package co.udea.certificacion.moduloseguimientodeordenes.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/orders/order_status.feature",
    glue     = "co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions",
    //tags     = "@requiresLogin",
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class StatusRunner {


}
