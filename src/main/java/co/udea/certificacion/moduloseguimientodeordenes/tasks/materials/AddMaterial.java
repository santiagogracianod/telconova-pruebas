package co.udea.certificacion.moduloseguimientodeordenes.tasks.materials;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class AddMaterial implements Task {

  private final String material;
  private final int    qty;

  public AddMaterial(String material,int qty){
      this.material = material;
      this.qty      = qty;
  }
  public static AddMaterial toOrder(String material,int qty){
      return Tasks.instrumented(AddMaterial.class, material, qty);
  }

  @Override
  public <T extends Actor> void performAs(T actor){
      actor.attemptsTo(
          SelectMaterial.named(material),
          EnterQuantity.of(qty),
          PressAdd.button()
      );
  }
}
