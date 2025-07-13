#Author: Santiago Graciano

Feature: Wikipedia Search

    Como un usuario
    Quiero Ingresar a Wikipedia
    Para buscar información sobre un tema

    Scenario: Buscar un tema en Wikipedia
        Given que estoy en la página principal de Wikipedia
        When ingreso la palabre testing en el campo de búsqueda
        Then debería ver la palabre Test (assessment) en los resultados de búsqueda