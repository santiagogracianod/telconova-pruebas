package co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import co.udea.certificacion.moduloseguimientodeordenes.questions.login.ValidationLogin;
import co.udea.certificacion.moduloseguimientodeordenes.questions.login.ValidationLoginError;
import co.udea.certificacion.moduloseguimientodeordenes.tasks.login.Open;
import co.udea.certificacion.moduloseguimientodeordenes.tasks.login.Validate;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinition {

  private Actor tecnico = OnStage.theActorCalled("Técnico");

  @Before
  public void setStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Given("que estoy en la página de inicio de sesión")
  public void queEstoyEnLaPáginaDeInicioDeSesión() {
    // Write code here that turns the phrase above into concrete actions
    tecnico.attemptsTo(
        Open.theLoginPage()
    );
  }

  @When("ingreso mi nombre de usuario {string} y contraseña {string}")
  public void ingresoMiNombreDeUsuarioYContraseñaVálidos(String username, String password) {
    tecnico.attemptsTo(
        Validate.withCredentials(username, password)
    );
  }

  @Then("debería ser redirigido al panel de control")
  public void deberíaSerRedirigidoAlPanelDeControl() {
    tecnico.should(
        seeThat(
          ValidationLogin.es(), 
          containsString("Panel de Órdenes")
        )
    );
  }

  @Then("debería ver el mensaje de error {string}")
  public void deberíaVerElMensajeDeError(String string) {
    tecnico.should(
      seeThat(
        ValidationLoginError.es(), 
        containsString("Credenciales inválidas. Por favor intenta de nuevo")
      )
    );
  }

}
