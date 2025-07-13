package co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders;


import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("")
public class OrdersPage extends PageObject {


  public static final Target ORDERS_TABLE = Target.the("Tabla de órdenes")
      .locatedBy("//table[@id='orders-table']/tbody/tr");

  public static Target FIRST_ORDER_ROW (String code) {
    String xpath = String.format(
        "//table[@id='orders-table']//tr[td[1][normalize-space()='%s']]//a[contains(.,'Ver')]",
        code
    );
    return Target.the("botón Ver de la orden " + code)
                 .locatedBy(xpath);
  }
   
  public static final Target ORDER_CODE_IN_ROW = Target.the("primera fila de la tabla de órdenes")
      .locatedBy("//table[@id='orders-table']/tbody/tr[1]/td[1]");

}
