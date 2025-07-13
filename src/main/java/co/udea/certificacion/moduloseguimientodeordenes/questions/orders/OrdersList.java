package co.udea.certificacion.moduloseguimientodeordenes.questions.orders;

import java.util.List;
import java.util.stream.Collectors;

import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrdersPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class OrdersList implements Question<List<String>> {

    public static OrdersList existentes() {
        return new OrdersList();
    }

    @Override
    public List<String> answeredBy(Actor actor) {

        // 1. Obtén todos los <tr> que encontró el Target
        List<WebElementFacade> filas =
                OrdersPage.ORDERS_TABLE.resolveAllFor(actor);

        // 2. Extrae su texto y devuélvelo como List<String>
        return filas.stream()
                    .map(WebElementFacade::getText)
                    .collect(Collectors.toList());   
    }
}
