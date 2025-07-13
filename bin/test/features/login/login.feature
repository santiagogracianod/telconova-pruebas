#Author: Santiago Graciano

Feature: Hacer login en la aplicación

    Como tecnico 
    Quiero poder iniciar sesión en la aplicación 
    Para gestionar tareas y ver los informes del sistema.

    @loginInvalido
    Scenario: Login con credenciales inválidas
        Given que estoy en la página de inicio de sesión
        When ingreso mi nombre de usuario "jprodriguez" y contraseña "12345678"
        Then debería ver el mensaje de error "Credenciales inválidas. Por favor intenta de nuevo"
    
    @requiresLogin
    Scenario: Iniciar sesión con éxito
        Given que estoy en la página de inicio de sesión
        When ingreso mi nombre de usuario "jrodriguez" y contraseña "tecnico123"
        Then debería ser redirigido al panel de control


    