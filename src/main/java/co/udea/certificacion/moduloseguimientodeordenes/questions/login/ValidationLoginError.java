package co.udea.certificacion.moduloseguimientodeordenes.questions.login;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.login.LoginResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidationLoginError implements Question<String> {

    public static ValidationLoginError es() {
        return new ValidationLoginError();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginResultPage.ERROR_MESSAGE_TEXT)
                .answeredBy(actor);
    }

}
