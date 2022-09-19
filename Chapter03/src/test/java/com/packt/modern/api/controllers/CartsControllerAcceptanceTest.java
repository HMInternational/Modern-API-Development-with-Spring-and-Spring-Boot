package com.packt.modern.api.controllers;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartsControllerAcceptanceTest {
    private final String customerId = "customer-uuid";

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
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
                .body("items.size()", is(2))
                .body("_links.self.href", not(blankOrNullString()))
                .body("_links.cart-items.href", not(blankOrNullString()));
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