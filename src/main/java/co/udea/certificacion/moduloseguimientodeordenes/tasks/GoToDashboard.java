package co.udea.certificacion.moduloseguimientodeordenes.tasks;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class GoToDashboard implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(DashboardPage.HOME_PAGE_BUTTON)
        );
    }

    public static GoToDashboard navigate() {
        return Tasks.instrumented(GoToDashboard.class);
    }

}
