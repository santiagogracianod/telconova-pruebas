package co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;

import co.udea.certificacion.moduloseguimientodeordenes.questions.materials.MaterialCount;
import co.udea.certificacion.moduloseguimientodeordenes.questions.materials.SuccessMesage;
import co.udea.certificacion.moduloseguimientodeordenes.tasks.materials.EnterQuantity;
import co.udea.certificacion.moduloseguimientodeordenes.tasks.materials.MaterialsList;
import co.udea.certificacion.moduloseguimientodeordenes.tasks.materials.PressAdd;
import co.udea.certificacion.moduloseguimientodeordenes.tasks.materials.SelectMaterial;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class MaterialsStepDefinition {

  private Actor tecnico = OnStage.theActorCalled("Tecnico");

  @When("selecciono el material {string}")
  public void seleccionoElMaterial(String string) {
    tecnico.attemptsTo(
        SelectMaterial.named(string));
  }

  @When("indico la cantidad {int}")
  public void indicoLaCantidad(Integer quantity) {
    tecnico.attemptsTo(
        EnterQuantity.of(quantity));
  }

  @When("presiono el botón Añadir")
  public void presionoElBotónAñadir() {
    tecnico.attemptsTo(
        PressAdd.button());
  }

  @Then("debería aparecer el mensaje de éxito {string}")
  public void deberíaAparecerElMensajeDeÉxito(String esperado) {
    // Espera a que el mensaje de éxito sea visible
    // Valida el contenido usando la Question
    tecnico.should(
        seeThat(
            SuccessMesage.displayed(), containsString(esperado)));
  }

  @Then("debería ver al menos un material en la orden")
  public void deberiaVerAlMenosUnMaterialEnLaOrden() {
    tecnico.attemptsTo(
        MaterialsList.toBeVisible());

    tecnico.should(
        seeThat(
            MaterialCount.total(), greaterThan(0)));

  }

}
