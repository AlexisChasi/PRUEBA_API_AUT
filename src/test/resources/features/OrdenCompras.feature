Feature: Compra Tienda
@OrdenTienda
  Scenario: Orden Compra
    Given Dado que estoy en la tienda
    When Creo una orden con los siguientes datos
      | id      | petId | quantity | shipDate               | status  | complete |
      | 10      | 100   | 3        | 2024-06-30T18:07:36.130Z | placed  | true     |
    Then Valido que la orden fue creada correctamente con código de respuesta sea 200
    And Valido que el estado de la orden es "placed"
