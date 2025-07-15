package co.udea.certificacion.moduloseguimientodeordenes.interactions;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectMaterial implements Interaction {

    private final String material;

    public SelectMaterial(String material){ this.material = material; }

    public static SelectMaterial named(String material){
        return Instrumented.instanceOf(SelectMaterial.class)
                           .withProperties(material);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
            Click.on(OrderMaterialsPage.MATERIAL_TRIGGER),
            WaitUntil.the(OrderMaterialsPage.MATERIAL_OPTION(material),
                          WebElementStateMatchers.isClickable())
                     .forNoMoreThan(5).seconds(),
            Scroll.to(OrderMaterialsPage.MATERIAL_OPTION(material)),
            Click.on(OrderMaterialsPage.MATERIAL_OPTION(material))
        );
    }
}
