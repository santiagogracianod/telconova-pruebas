package co.udea.certificacion.moduloseguimientodeordenes.tasks.login;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.login.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class Open implements Task {

  private LoginPage loginPage;

  public static Open theLoginPage() {
    return Tasks.instrumented(Open.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        net.serenitybdd.screenplay.actions.Open.browserOn(loginPage)
    );
  }

}
