package co.udea.certificacion.moduloseguimientodeordenes.tasks.materials;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AddMaterial implements Task {

  private final String material;
  private final String quantity;

  public AddMaterial(String material, int quantity) {
    this.material = material;
    this.quantity = String.valueOf(quantity);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    /* Abre y elige material */
    actor.attemptsTo(
        Click.on(OrderMaterialsPage.MATERIAL_TRIGGER),
        WaitUntil.the(
            OrderMaterialsPage.MATERIAL_OPTION(material),
            WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(),

        /* Ingresa cantidad */
        Clear.field(OrderMaterialsPage.QTY_INPUT),
        Enter.theValue(quantity)
            .into(OrderMaterialsPage.QTY_INPUT),

        /* Espera botón habilitado y clic */
        WaitUntil.the(
            OrderMaterialsPage.ADD_BUTTON,
            WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds(),

        Click.on(OrderMaterialsPage.ADD_BUTTON)

    );
  }

  public static AddMaterial toOrder(String material, int quantity) {
    return Tasks.instrumented(AddMaterial.class, material, quantity);
  }

}
