package co.udea.certificacion.moduloseguimientodeordenes.questions.status;


import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderDetailsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CurrentOrderStatus implements Question<String> {


    public static CurrentOrderStatus is() {
        return new CurrentOrderStatus();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(OrderDetailsPage.STATE_BADGE)
                .answeredBy(actor);
    }

}
