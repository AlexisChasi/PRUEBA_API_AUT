package com.everis.base.stepDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;
import com.everis.base.OrderServiceStep;

import com.everis.base.models.Order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ConsultaOrdenStepDef {

    @Steps
    OrderServiceStep orderServiceStep;

    private Order responseOrder;

    @Given("Dado que estoy en la tienda para verificar")
    public void dadoQueEstoyEnLaTiendaParaVerificar() {
        // Puedes agregar aquí cualquier configuración inicial necesaria
    }

    @When("Consulto la orden con ID {string}")
    public void consultoLaOrdenConID(String id) {
        responseOrder = orderServiceStep.consultarOrden(id);
    }


    @Then("Valido que la orden obtenida tiene los siguientes datos")
    public void validoQueLaOrdenObtenidaTieneLosSiguientesDatos(DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> expected : expectedData) {
            assertEquals(Integer.parseInt(expected.get("id")), responseOrder.getId());
            assertEquals(Integer.parseInt(expected.get("petId")), responseOrder.getPetId());
            assertEquals(Integer.parseInt(expected.get("quantity")), responseOrder.getQuantity());
            assertEquals(expected.get("shipDate"), responseOrder.getShipDate());
            assertEquals(expected.get("status"), responseOrder.getStatus());
            assertEquals(Boolean.parseBoolean(expected.get("complete")), responseOrder.isComplete());
        }
    }

}
