package com.everis.base.stepDefinitions;

import com.everis.base.OrdenStep;
import com.everis.base.models.Orden;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Map;

public class OrdenStepDef {

    @Steps
    OrdenStep ordenStep;

    private Orden responseOrden;

    @Given("Dado que estoy en la tienda")
    public void dadoQueEstoyEnLaTienda() {
        // Aquí puedes añadir cualquier precondición necesaria, como navegar a una URL específica.
    }

    @When("Creo una orden con los siguientes datos")
    public void creoUnaOrdenConLosSiguientesDatos(DataTable dataTable) {
        // Convierte DataTable en una lista de mapas para obtener los valores
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String id = row.get("id");
            String petId = row.get("petId");
            int quantity = Integer.parseInt(row.get("quantity"));
            String shipDate = row.get("shipDate");
            String status = row.get("status");
            boolean complete = Boolean.parseBoolean(row.get("complete"));

            // Llama al método crearOrden de OrdenStep
            responseOrden = ordenStep.crearOrden(id, petId, quantity, shipDate, status, complete);
        }
    }

    @Then("Valido que la orden fue creada correctamente con código de respuesta sea {int}")
    public void validoQueLaOrdenFueCreadaCorrectamenteConCódigoDeRespuestaSea(int expectedStatusCode) {
        // Valida el código de respuesta
        assertEquals(expectedStatusCode, responseOrden.getStatusCode());
    }

    @And("Valido que el estado de la orden es {string}")
    public void validoQueElEstadoDeLaOrdenEs(String expectedStatus) {
        // Valida el estado de la orden
        assertEquals(expectedStatus, responseOrden.getStatus());
    }
}
