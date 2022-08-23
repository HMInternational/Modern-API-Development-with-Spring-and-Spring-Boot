package com.packt.modern.api.controllers;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

class CartsControllerAcceptanceTest {
    private final String customerId = "uuid";

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new CartsController());
    }

    @Test
    void getCartItemsByCustomerId_when_customer_exists() {
        given()
                .accept(MediaType.APPLICATION_JSON_VALUE)

                .when()
                .get("/api/v1/carts/{customerId}", customerId)

                .then()
                .log().all()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .assertThat()
                .body("customerId", equalTo(customerId))
                .body("items.size()", is(2));
    }

    @Test
    void getCartItemsByCustomerId_when_customer_not_exists() {
        given()
                .accept(MediaType.APPLICATION_JSON_VALUE)

                .when()
                .get("/api/v1/carts/{customerId}", "not-existing-customer")

                .then()
                .log().all()
                .statusCode(404)
                .body(blankOrNullString());
    }

}