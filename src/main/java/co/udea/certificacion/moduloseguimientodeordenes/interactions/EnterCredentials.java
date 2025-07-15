package co.udea.certificacion.moduloseguimientodeordenes.interactions;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.login.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

public class EnterCredentials implements Interaction {

    private final String user;
    private final String pass;

    public EnterCredentials(String user, String pass) {   // ← debe ser PUBLIC
        this.user = user;
        this.pass = pass;
    }

    /** Fábrica estática legible en el reporte */
    public static EnterCredentials of(String user, String pass) {
        return net.serenitybdd.core.steps.Instrumented.instanceOf(EnterCredentials.class)
                            .withProperties(user, pass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(user).into(LoginPage.USERNAME_FIELD),
            Enter.theValue(pass).into(LoginPage.PASSWORD_FIELD),
            Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
