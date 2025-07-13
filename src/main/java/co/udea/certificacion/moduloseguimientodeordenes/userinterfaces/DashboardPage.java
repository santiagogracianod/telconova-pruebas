package co.udea.certificacion.moduloseguimientodeordenes.userinterfaces;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DashboardPage extends PageObject {

    public static final Target HOME_PAGE_BUTTON = Target.the("Botón de búsqueda en Wikipedia")
            .locatedBy("/html/body/div/header/div/div[1]/a");
    
            public static final Target NAV_TITLE = Target.the("Botón de búsqueda en Wikipedia")
            .locatedBy("/html/body/div/header/div/div[1]/a/span");

}
