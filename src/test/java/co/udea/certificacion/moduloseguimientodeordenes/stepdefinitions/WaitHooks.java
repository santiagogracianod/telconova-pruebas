package co.udea.certificacion.moduloseguimientodeordenes.stepdefinitions;

import io.cucumber.java.After;

public class WaitHooks {

    @After(order = 99)         // se ejecuta al final, antes de cerrar el driver
    public void waitABit() throws InterruptedException {
        Thread.sleep(3000);  // 10 000 ms = 10 s
    }
}
