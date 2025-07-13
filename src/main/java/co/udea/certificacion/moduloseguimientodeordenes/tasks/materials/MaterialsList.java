package co.udea.certificacion.moduloseguimientodeordenes.tasks.materials;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class MaterialsList implements Task {

    @Override
   public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
            WaitUntil.the(OrderMaterialsPage.ALL_ROWS,
                          WebElementStateMatchers.isVisible())
                     .forNoMoreThan(10).seconds()
        );
    }

    public static MaterialsList toBeVisible() {
      return Tasks.instrumented(MaterialsList.class);
    }

}
