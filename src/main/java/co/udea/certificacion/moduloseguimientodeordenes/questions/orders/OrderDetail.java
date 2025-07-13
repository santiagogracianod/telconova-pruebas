package co.udea.certificacion.moduloseguimientodeordenes.questions.orders;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderDetailsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class OrderDetail implements Question<String> {

    public static OrderDetail withId() {
        return new OrderDetail();
    }

    @Override
    public String answeredBy(Actor actor) {
        // Ejemplo de título:  "Orden #ORD-000003"
        String raw = Text.of(OrderDetailsPage.ORDER_TITLE).answeredBy(actor);
        // Extraemos solo el código (lo que va después de '#')
        System.out.println("Raw Order Title: " + raw);
        
        return raw.replace("Orden", "")   // quita la palabra
                  .replace("#", "")       // quita el #
                  .trim();                // quita espacios
    }
}
