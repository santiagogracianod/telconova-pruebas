package co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions;

import co.udea.certificacion.moduloseguimientodeordenes.tasks.login.Open;
import co.udea.certificacion.moduloseguimientodeordenes.tasks.login.Validate;
import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.DashboardPage;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class LoginHooks {

  @Before(order = 0)
  public void setStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  /**
   * Este hook se ejecuta antes de cada escenario que requiera autenticación.
   */
  @Before("@requiresLogin")
  public void loginBereforeScenario() {
    // Aquí puedes agregar lógica para iniciar sesión antes de cada escenario que
    // requiera autenticación
    // Por ejemplo, podrías crear un actor y realizar la acción de inicio de sesión
    Actor tecnico = OnStage.theActorCalled("tecnico");



    if (DashboardPage.NAV_TITLE.resolveFor(tecnico).isVisible()) {
      return;
  }

    tecnico.attemptsTo(
        Open.theLoginPage(),
        Validate.withCredentials("jrodriguez", "tecnico123"));
  }

}
