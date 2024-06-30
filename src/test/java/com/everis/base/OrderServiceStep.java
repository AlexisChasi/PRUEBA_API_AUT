package com.everis.base;

import com.everis.base.models.Order;
import io.restassured.response.Response;
import static net.serenitybdd.rest.SerenityRest.given;

public class OrderServiceStep {
    private String BASE_URL = "https://petstore.swagger.io/v2";

    public Order consultarOrden(String id) {
        Response response = given()
                .baseUri(BASE_URL)
                .log().all()
                .when()
                .get("/store/order/" + id)
                .then()
                .log().all()
                .extract().response();

        return response.as(Order.class);
    }
}
