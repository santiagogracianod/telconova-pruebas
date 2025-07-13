package co.udea.certificacion.moduloseguimientodeordenes.questions.materials;


import co.udea.certificacion.moduloseguimientodeordenes.userinterfaces.orders.OrderMaterialsPage;
import net.serenitybdd.screenplay.Question;

public class MaterialExists implements Question<Boolean> {

    private final String material;

    public MaterialExists(String material) {
        this.material = material;
    }

    public static MaterialExists inList(String material) {
        return new MaterialExists(material);
    }

    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return OrderMaterialsPage.ROW(material)
                .resolveFor(actor)
                .isVisible();
    }

}
