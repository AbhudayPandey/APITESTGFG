package org.example;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllRequestTest {
    @Test
    public void testGetObjects() {

        // Given
        given()
                .baseUri("https://api.restful-api.dev")

                // When
                .when()
                .get("/objects")

                // Then
                .then()
                .statusCode(200)//asseration
                .body("size()", greaterThan(0)) // Ensuring response is not empty
                .body("id", notNullValue())
                .body("name", notNullValue())
                .log().body();
    }

    @Test
    public void testGetObjectsNegative() {

        // Given
        given()
                .baseUri("https://api.restful-api.dev")

                // When
                .when()
                .get("/objects")

                // Then
                .then()
                .statusCode(400)//asseration
                .body("size()", greaterThan(0))
                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("price", everyItem(greaterThan(0)))
                .body("createdAt", everyItem(notNullValue()))
                .log().body();
    }

}
