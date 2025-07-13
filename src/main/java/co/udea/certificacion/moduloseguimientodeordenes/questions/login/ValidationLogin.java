package co.udea.certificacion.moduloseguimientodeordenes.questions.login;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.login.LoginResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidationLogin implements Question<String> {

    public static ValidationLogin es(){
        return new ValidationLogin();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginResultPage.LOGIN_RESULT_TEXT)
                .answeredBy(actor);
    }


}
