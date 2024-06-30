Feature: Consultar Orden
  @ConsultaOrden
  Scenario: Consultar Orden por ID
    Given Dado que estoy en la tienda para verificar
    When Consulto la orden con ID "10"
    Then Valido que la orden obtenida tiene los siguientes datos
      | id      | petId | quantity | shipDate               | status  | complete |
      | 10      | 100   | 3        | 2024-06-30T18:07:36.130+0000 | placed  | true     |
