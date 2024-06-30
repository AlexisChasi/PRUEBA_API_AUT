package com.everis.base;

import com.everis.base.models.Orden;
import io.restassured.response.Response;
import static net.serenitybdd.rest.SerenityRest.given;

public class OrdenStep {
    private String URL_BASE = "https://petstore.swagger.io/v2";

    public Orden crearOrden(String id, String petId, int quantity, String shipDate, String status, boolean complete) {
        Orden orden = new Orden();
        orden.setId(Integer.parseInt(id));
        orden.setPetId(Integer.parseInt(petId));
        orden.setQuantity(quantity);
        orden.setShipDate(shipDate);
        orden.setStatus(status);
        orden.setComplete(complete);

        Response response = given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .body(orden)
                .log().all()
                .when()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();

        Orden responseOrden = response.as(Orden.class);
        responseOrden.setStatusCode(response.getStatusCode());

        System.out.println("OUT: " + responseOrden.getId());
        System.out.println("OUT: " + responseOrden.getPetId());
        System.out.println("OUT: " + responseOrden.getStatus());
        System.out.println("OUT: " + responseOrden.isComplete());
        System.out.println("OUT: " + responseOrden.getStatusCode());

        return responseOrden;
    }
}
