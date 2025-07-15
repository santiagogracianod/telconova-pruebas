package co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;

import co.udea.certificacion.moduloseguimientodeordenes.questions.materials.MaterialCount;
import co.udea.certificacion.moduloseguimientodeordenes.questions.materials.SuccessMesage;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class MaterialsStepDefinition {

    private final Actor tecnico = OnStage.theActorCalled("Tecnico");

    // ---------------- WHEN ----------------
    @When("selecciono el material {string}")
    public void seleccionoElMaterial(String nombre) {
        tecnico.attemptsTo(
            co.udea.certificacion.moduloseguimientodeordenes.interactions.SelectMaterial.named(nombre)
        );
    }

    @When("indico la cantidad {int}")
    public void indicoLaCantidad(Integer cantidad) {
        tecnico.attemptsTo(
            co.udea.certificacion.moduloseguimientodeordenes.tasks.materials.EnterQuantity.of(cantidad)
        );
    }

    @When("presiono el botón Añadir")
    public void presionoElBotonAñadir() {
        tecnico.attemptsTo(
            co.udea.certificacion.moduloseguimientodeordenes.tasks.materials.PressAdd.button()
        );
    }

    // ---------------- THEN ----------------
    @Then("debería aparecer el mensaje de éxito {string}")
    public void deberiaAparecerElMensajeDeExito(String esperado) {
        tecnico.should(
            seeThat(SuccessMesage.displayed(), containsString(esperado))
        );
    }

    @Then("debería ver al menos un material en la orden")
    public void deberiaVerMateriales() {
        // Interaction que simplemente espera que las filas aparezcan
        tecnico.attemptsTo(co.udea.certificacion.moduloseguimientodeordenes.tasks.materials.MaterialsList.toBeVisible());

        // Question que cuenta las filas
        tecnico.should(
            seeThat(MaterialCount.total(), greaterThan(0))
        );
    }
}
