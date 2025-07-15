package co.udea.certificacion.moduloseguimientodeordenes.tasks.login;

import co.udea.certificacion.moduloseguimientodeordenes.interactions.EnterCredentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Validate implements Task {

    private final String user;
    private final String pass;

    public Validate(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public static Validate withCredentials(String user, String pass) {
        return Tasks.instrumented(Validate.class, user, pass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            EnterCredentials.of(user, pass) 
        );
    }
}
