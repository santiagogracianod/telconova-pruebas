package co.udea.certificacion.moduloseguimientodeordenes.tasks.materials;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class PressAdd implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(OrderMaterialsPage.ADD_BUTTON,
            WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds(),
        Click.on(OrderMaterialsPage.ADD_BUTTON));
  }

  public static PressAdd button() {
    return Tasks.instrumented(PressAdd.class);
  }

}
