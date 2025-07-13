package co.udea.certificacion.moduloseguimientodeordenes.questions.materials;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SuccessMesage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
      WaitUntil.the(OrderMaterialsPage.SUCCESS_MSG, 
          net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible())
          .forNoMoreThan(10).seconds();

        return Text.of(OrderMaterialsPage.SUCCESS_MSG).answeredBy(actor).trim();
    }

    public static SuccessMesage displayed() {
        return new SuccessMesage();
    }

}
