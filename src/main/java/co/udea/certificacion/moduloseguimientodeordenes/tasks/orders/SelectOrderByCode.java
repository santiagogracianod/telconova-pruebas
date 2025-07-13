package co.udea.certificacion.moduloseguimientodeordenes.tasks.orders;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrdersPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectOrderByCode implements Task {

  private final String code;

  public SelectOrderByCode(String code) {
    this.code = code;
  }

  public static SelectOrderByCode withCode(String code) {
    return Tasks.instrumented(SelectOrderByCode.class, code);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    // Implement the logic to select the first order here
    // This could involve clicking on a specific element representing the first
    // order
    // For example:
    actor.attemptsTo(Click.on(OrdersPage.FIRST_ORDER_ROW(code)));
  }

  

}
