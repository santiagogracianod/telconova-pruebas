package co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import co.udea.certificacion.moduloseguimientodeordenes.questions.orders.OrderDetail;
import co.udea.certificacion.moduloseguimientodeordenes.questions.orders.OrdersList;
import co.udea.certificacion.moduloseguimientodeordenes.tasks.orders.SelectOrderByCode;
import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderDetailsPage;
import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrdersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.containsString;

public class OrdersStepDefinition {

  private Actor tecnico = OnStage.theActorCalled("Tecnico");

  @Then("deberia ver una lista de órdenes asignadas")
  public void deberiaVerUnaListaDeOrdenesAsignadas() {
    // Espera hasta que al menos una fila esté visible (máx. 10 s)
    tecnico.attemptsTo(
        WaitUntil.the(
            OrdersPage.ORDERS_TABLE, // Target <tr>
            WebElementStateMatchers.isVisible() // Condición
        ).forNoMoreThan(10).seconds());

    // Validación: lista no vacía
    tecnico.should(
        seeThat(
            OrdersList.existentes(),
            hasSize(greaterThan(0))));
  }

  @Given("la tabla de ordenes esta visible")
  public void laTablaDeOrdenesEstaVisible() {
    // Asegúrate de que la tabla de órdenes esté visible antes de realizar cualquier
    // acción
    tecnico.attemptsTo(
        WaitUntil.the(
            OrdersPage.ORDERS_TABLE,
            WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
  }

  @When("selecciono la orden con codigo {string}")
  public void seleccionoLaOrdenConCodigo(String codigo) {
    // Espera hasta que el botón "Ver" de la orden esté visible
    tecnico.attemptsTo(
        WaitUntil.the(
            OrdersPage.FIRST_ORDER_ROW(codigo),
            WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());

    // Haz clic en el botón "Ver" de la orden
    tecnico.attemptsTo(
        SelectOrderByCode.withCode(codigo));
  }

  @Then("deberia ver los detalles de la orden {string}")
  public void deberiaVerLosDetallesDeLaOrden(String codigo) {
    // Espera hasta que el botón "Ver" de la orden esté visible
    tecnico.attemptsTo(
        WaitUntil.the(
            OrderDetailsPage.ORDER_DETAIL_TITLE,
            WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
    // Validación: el código de la orden en la primera fila debe coincidir con el
    // código seleccionado
    tecnico.should(
        seeThat(
            "El código mostrado en la vista de detalle",
            OrderDetail.withId(),
            containsString(codigo)
        ));
  }

}
