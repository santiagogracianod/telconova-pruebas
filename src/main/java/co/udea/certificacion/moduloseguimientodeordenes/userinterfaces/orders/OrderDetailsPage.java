package co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("")
public class OrderDetailsPage extends PageObject {

  public static final Target ORDER_TITLE = Target.the("título con el número de orden")
      .locatedBy("/html/body/div/main/div[1]/h1");

  public static final Target ORDER_DETAIL_TITLE = Target.the("título con el número de orden")
      .locatedBy("/html/body/div/main/div[2]/div[1]/div[1]/div[1]/h3");


  // Alternativa más específica basada en tu estructura
  public static final Target STATE_SELECT_TRIGGER = Target.the("trigger del select de estado")
      .locatedBy("/html/body/div/main/div[2]/div[2]/div[1]/div[2]/form/button[1]");
  // Contenido del dropdown cuando está abierto (Radix UI Portal)
  public static final Target STATE_DROPDOWN_CONTENT = Target.the("contenido del dropdown de estado")
      .locatedBy("//div[@role='listbox' or @data-radix-select-content]");

  // Botón actualizar
  public static final Target UPDATE_STATE_BTN = Target.the("botón Actualizar estado")
      .locatedBy("/html/body/div/main/div[2]/div[2]/div[1]/div[2]/form/button[2]");

  public static final Target STATE_BADGE = Target.the("badge de estado en la tarjeta de detalles")
      .locatedBy("/html/body/div[3]/div/p");


  // Selector más robusto que busca en múltiples lugares
  public static Target RADIX_OPTION(String texto) {
    return Target.the("opción radix " + texto)
        .locatedBy("//div[@role='option' and normalize-space()='" + texto + "'] | " +
            "//*[@data-radix-select-item and normalize-space()='" + texto + "'] | " +
            "//*[contains(@class,'select-item') and normalize-space()='" + texto + "']");
  }

  
}