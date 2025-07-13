package co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.DashboardPage;
import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import io.cucumber.java.After;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class OrderDetailsCleanUpHooks {
  /** Se ejecuta DESPUÉS de cada escenario con @agregarMaterial */
  @After("@agregarMaterial")
  public void closeToastAndReturn() {
    Actor tecnico = OnStage.theActorInTheSpotlight();

    // 1) Cerrar el toast o diálogo solo si sigue visible
    tecnico.attemptsTo(

    Check.whether(
        OrderMaterialsPage.SUCCESS_OK_BTN.resolveFor(tecnico).isVisible()
    ).andIfSo( // si el botón está visible, lo cierra
        WaitUntil.the(
          OrderMaterialsPage.SUCCESS_OK_BTN, 
          WebElementStateMatchers.isVisible())
            .forNoMoreThan(1).seconds(
    ),
        Click.on(OrderMaterialsPage.SUCCESS_OK_BTN)
    ));
    // 2) Volver al dashboard
    tecnico.attemptsTo(
        Click.on(DashboardPage.HOME_PAGE_BUTTON), // o el menú
        WaitUntil.the(DashboardPage.NAV_TITLE, 
        WebElementStateMatchers.isVisible())
            .forNoMoreThan(5).seconds());
  }

}
