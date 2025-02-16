package org.example;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetOneRequest {

    @Test
    public void testGetSingleObject() {

        // Given
        given()
                .baseUri("https://api.restful-api.dev")

                // When
                .when()
                .get("/objects/7")

                // Then
                .then()
                .statusCode(200)
                .body("name", equalTo("Apple MacBook Pro 16"))
                .body("data.year", equalTo(2019))
                .log().body();
    }

    @Test
    public void testGetSingleObjectAssertPostive() {

        // Given
        given()
                .baseUri("https://api.restful-api.dev")

                // When
                .when()
                .get("/objects/7")

                // Then
                .then()
                .statusCode(200)
                .body("data.year", equalTo(2019))
                .body("data.price", equalTo(1849.99f))
                .log().body();
    }

    @Test
    public void testGetSingleObjectAssertNegative() {

        // Given
        given()
                .baseUri("https://api.restful-api.dev")

                // When
                .when()
                .get("/objects/7")

                // Then
                .then()
                .statusCode(200)
                .body("data.year", equalTo(2018))
                .body("data.price", equalTo(1849.99f))
                .log().body();
    }
}
