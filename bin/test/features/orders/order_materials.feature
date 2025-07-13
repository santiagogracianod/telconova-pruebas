 #Author: Santiago Graciano

@requiresLogin @materiales
Feature: Gestión de materiales utilizados en una orden
  Como técnico
  Quiero registrar y consultar los materiales usados
  Para dejar evidencia del trabajo realizado

  Background: Estoy en el detalle de la orden
    Given que estoy en el detalle de la orden "ORD-000004"


  @agregarMaterial
  Scenario: Añadir un material a la orden
    When selecciono el material "Antena WiFi"
     And indico la cantidad 1
     And presiono el botón Añadir
    Then debería aparecer el mensaje de éxito "Antena WiFi x1 añadido"


  @listarMateriales
  Scenario: Ver lista de materiales existentes
    Then debería ver al menos un material en la orden
