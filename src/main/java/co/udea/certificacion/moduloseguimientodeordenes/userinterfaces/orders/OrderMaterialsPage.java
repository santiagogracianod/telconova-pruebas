package co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/** Elementos de la tarjeta "Materiales utilizados" */
public class OrderMaterialsPage extends PageObject {


  public static final Target MATERIAL_TRIGGER =
      Target.the("trigger de selección de material")
            .locatedBy("/html/body/div/main/div[2]/div[2]/div[2]/div[2]/div/button[1]");

  /* Opción visible en el portal Radix */
 /*  public static Target MATERIAL_OPTION(String name){
      return Target.the("opción " + name)
                   .located(By.xpath(
                       "//div[@data-radix-select-item and normalize-space()='" + name + "']"
                   ));
  } */

  public static Target MATERIAL_OPTION(String name) {
    String locator =
          "//div[@role='option' and normalize-space()='" + name + "'] | "
        + "//*[@data-radix-select-item and normalize-space()='" + name + "'] | "
        + "//*[contains(@class,'select-item') and normalize-space()='" + name + "']";

    return Target.the("opción " + name)
                 .located(By.xpath(locator));
}

  

  /* Input cantidad */
  public static final Target QTY_INPUT =
      Target.the("input de cantidad")
            .located(By.cssSelector("input[type='number']"));

  /* Botón Añadir (texto) */
  public static final Target ADD_BUTTON =
      Target.the("botón Añadir")
            .locatedBy("/html/body/div/main/div[2]/div[2]/div[2]/div[2]/div/button[2]");
  /* Botón Añadir (texto) */
  public static final Target SUCCESS_OK_BTN =
      Target.the("botón Añadir")
            .locatedBy("/html/body/div[3]/button");

  /* Mensaje del diálogo */
  public static final Target SUCCESS_MSG =
      Target.the("mensaje de éxito")
            .located(By.cssSelector("div[role='alertdialog'] p"));

  /* Fila de material */
  public static Target ROW(String name){
      return Target.the("fila de " + name)
                   .located(By.xpath("//ul/li[div[contains(.,'" + name + "')]]"));
  }

  // OrderMaterialsPage.java
public static final Target ALL_ROWS =
Target.the("todas las filas de materiales")
      .located(By.cssSelector("ul li"));   // cada <li> es un material


  /* Cantidad mostrada */
  public static Target QTY_IN_ROW(String name){
      return Target.the("cantidad de " + name)
                   .located(By.xpath(
                       "//ul/li[div[contains(.,'" + name + "')]]//span[contains(.,'Cantidad')]"
                   ));
  }
}
