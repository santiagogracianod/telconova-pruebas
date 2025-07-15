package co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.login;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://telconona-frontend.vercel.app/login")
public class LoginPage extends PageObject {

  // Elementos de la página de inicio de sesión
  public static final Target USERNAME_FIELD = Target.the("campo usuario").locatedBy("//*[@id=\"email\"]");
  public static final Target PASSWORD_FIELD = Target.the("campo contraseña").locatedBy("//*[@id=\"password\"]");
  public static final Target LOGIN_BUTTON = Target.the("botón de inicio de sesión").locatedBy("/html/body/div/div/form/button");

  // Mensajes de error
  public static final String ERROR_MESSAGE = ".error-message";
}
