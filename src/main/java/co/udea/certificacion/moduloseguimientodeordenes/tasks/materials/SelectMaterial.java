package co.udea.certificacion.moduloseguimientodeordenes.tasks.materials;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectMaterial implements Task {

  private final String material;

  public SelectMaterial(String material) {
    this.material = material;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(OrderMaterialsPage.MATERIAL_TRIGGER),

        /* espera a que la opción esté clickable en el portal */
        WaitUntil.the(OrderMaterialsPage.MATERIAL_OPTION(material),
            WebElementStateMatchers.isClickable())
            .forNoMoreThan(5).seconds(),

        /* scroll opcional para asegurar visibilidad */
            Scroll.to(OrderMaterialsPage.MATERIAL_OPTION(material)),
            Click.on(OrderMaterialsPage.MATERIAL_OPTION(material))
        
        );
  }

  public static SelectMaterial named(String material) {
    return Tasks.instrumented(SelectMaterial.class, material);
  }

}
