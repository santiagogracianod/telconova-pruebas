package co.udea.certificacion.moduloseguimientodeordenes.tasks.status;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderDetailsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Change implements Task {
    
    private final String newStatus;
    
    public Change(String newStatus) {
        this.newStatus = newStatus;
    }
    
    public static Change to(String newStatus) {
        return Tasks.instrumented(Change.class, newStatus);
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            // 1. Hacer clic en el trigger del Select (botón combobox)
            Click.on(OrderDetailsPage.STATE_SELECT_TRIGGER),
            
            // 2. Esperar que aparezca el contenido del dropdown
            WaitUntil.the(OrderDetailsPage.STATE_DROPDOWN_CONTENT, WebElementStateMatchers.isVisible())
                .forNoMoreThan(5).seconds(),
            
            // 3. Hacer clic en la opción deseada
            Click.on(OrderDetailsPage.RADIX_OPTION(newStatus)),
            
            // 4. Esperar que el botón de actualizar esté habilitado
            WaitUntil.the(OrderDetailsPage.UPDATE_STATE_BTN, WebElementStateMatchers.isEnabled())
                .forNoMoreThan(5).seconds(),
            
            // 5. Hacer clic en actualizar
            Click.on(OrderDetailsPage.UPDATE_STATE_BTN)
        );
    }
}
