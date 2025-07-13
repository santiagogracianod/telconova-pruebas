package co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.login;

import net.serenitybdd.screenplay.targets.Target;

public class LoginResultPage {

  public static final Target LOGIN_RESULT_TEXT = Target.the("Texto del resultado de inicio de sesión")
      .locatedBy("/html/body/div/main/div[1]/h1");
  
  public static final Target ERROR_MESSAGE_TEXT = Target.the("Texto del resultado de validacion inicio de sesión")
      .locatedBy("/html/body/div/div/form/div[1]/div");

}
