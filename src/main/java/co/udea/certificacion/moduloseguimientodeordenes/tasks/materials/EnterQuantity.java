package co.udea.certificacion.moduloseguimientodeordenes.tasks.materials;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterQuantity implements Task {

    private final int quantity;

    public EnterQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Clear.field(OrderMaterialsPage.QTY_INPUT),
            Enter.theValue(String.valueOf(quantity)).into(OrderMaterialsPage.QTY_INPUT)
        );
    }

    public static EnterQuantity of(int quantity) {
        return Tasks.instrumented(EnterQuantity.class, quantity);
    }

}
