 #Author: Santiago Graciano

@requiresLogin
@listarOrdenes 
@detalleOrden 
Feature: Cambio de estado de una orden de trabajo 
    Como tecnico 
    Quiero poder cambiar el estado de una orden de trabajo 
    Para reflejar el progreso real de la intervención.
 
 @cambiarEstadoOrden
 Scenario: Cambiar estado de una orden
    Given que estoy en el detalle de la orden "ORD-000004"
    When cambio el estado de la orden a "En curso"
    Then deberia ver que el estado de la orden ha cambiado a "En curso"