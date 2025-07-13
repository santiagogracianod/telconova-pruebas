package co.udea.certificacion.moduloseguimientodeordenes.tasks.login;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.login.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Validate implements Task {

  private final String username;
  private final String password;

  public Validate(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public static Validate withCredentials(String username, String password) {
    return Tasks.instrumented(Validate.class, username, password);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    // Aquí se implementaría la lógica para validar las credenciales
    // Por ejemplo, podrías usar un servicio web o una base de datos para verificar las credenciales
    // En este caso, simplemente se imprime un mensaje de validación
    System.out.println("Validando usuario: " + username + " con contraseña: " + password);

    actor.attemptsTo(
      Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
      Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
      Click.on(LoginPage.LOGIN_BUTTON)
        // Aquí podrías agregar acciones adicionales, como navegar a una página o realizar una solicitud
        // Por ejemplo, podrías usar Open.browserOn() para abrir una página específica
        // net.serenitybdd.screenplay.actions.Open.browserOn(new SomePage())
    );
  }

}
