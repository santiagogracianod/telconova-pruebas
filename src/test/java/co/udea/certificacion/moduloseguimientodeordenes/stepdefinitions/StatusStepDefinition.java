package co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import co.udea.certificacion.moduloseguimientodeordenes.tasks.orders.SelectOrderByCode;
import co.udea.certificacion.moduloseguimientodeordenes.tasks.status.Change;
import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderDetailsPage;
import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrdersPage;
import co.udea.certificacion.moduloseguimientodeordenes.questions.status.CurrentOrderStatus;

// Al inicio del archivo, junto con los demás static-imports:
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;


public class StatusStepDefinition {

  /**
   * El actor se crea una sola vez (cuando se instancia la clase)
   * asumiendo que OnStage.setTheStage() ya se llamó en un hook @Before(order =
   * 0).
   */
  private final Actor tecnico = OnStage.theActorCalled("Tecnico");

  @Given("que estoy en el detalle de la orden {string}")
  public void irAlDetalle(String codigo) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            WaitUntil.the(OrdersPage.ORDERS_TABLE, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
            SelectOrderByCode.withCode(codigo));
  }

  // ---------- WHEN ----------
  @When("cambio el estado de la orden a {string}")
  public void cambioElEstadoDeLaOrdenA(String nuevoEstado) {
    tecnico.attemptsTo(
        Change.to(nuevoEstado) // Task que selecciona y guarda el estado
    );
  }

  // ---------- THEN ----------
  @Then("deberia ver que el estado de la orden ha cambiado a {string}")
  public void deberiaVerQueElEstadoDeLaOrdenHaCambiadoA(String estadoEsperado) {
    // 1) Espera hasta que el badge muestre el texto esperado (máx. 10 s)
    tecnico.attemptsTo(
        WaitUntil.the(
            OrderDetailsPage.STATE_BADGE,
            containsText("Nuevo estado")
        ).forNoMoreThan(5).seconds()
    );

    // 2) Asertar valor exacto (si quieres incluir el prefijo quítalo o ajústalo)
    tecnico.should(
        seeThat(
            CurrentOrderStatus.is(), // Question que lee el estado mostrado
            equalTo("Nuevo estado: " + estadoEsperado)));
  }
}
