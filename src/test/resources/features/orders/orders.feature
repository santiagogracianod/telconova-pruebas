#Author: Santiago Graciano

Feature: Ver ordenes
  Como tecnico
  Quiero ver las ordenes que tengo asignadas
  Para validar estados y seguimiento


  @requiresLogin @listarOrdenes
  Scenario: Listar órdenes asignadas
    Then deberia ver una lista de órdenes asignadas
    
  @listarOrdenes @detallesOrden
  Scenario: Ver detalles de una orden
    Given la tabla de ordenes esta visible
    When selecciono la orden con codigo "ORD-000003"
    Then deberia ver los detalles de la orden "ORD-000003"


