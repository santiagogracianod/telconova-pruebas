package co.udea.certificacion.moduloseguimientodeordenes.questions.materials;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MaterialCount implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return OrderMaterialsPage.ALL_ROWS.resolveAllFor(actor).size();
    }

    public static MaterialCount total() {
        return new MaterialCount();
    }

}
