package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class PostNewObject {

    @Test
    public void testPostNewObject() {

        String payload = """
        {
           "name": "Apple MacBook Pro 16",
           "data": {
              "year": 2019,
              "price": 1849.99,
              "CPU model": "Intel Core i9",
              "Hard disk size": "1 TB"
           }
        }
        """;

        // Given
        given()
                .baseUri("https://api.restful-api.dev")
                .header("Content-Type", "application/json")
                .body(payload)

                // When
                .when()
                .post("/objects")

                // Then
                .then()
                .statusCode(200)
                .body("id", notNullValue())  // assertion to check  'id' is present
                .body("id", not(emptyOrNullString()))//assertion to check to check 'id' is empty
                .body("name", equalTo("Apple MacBook Pro 16"))
                .body("data.year", equalTo(2019))
                .body("data.price", equalTo(1849.99f))
                .body("data['CPU model']", equalTo("Intel Core i9"))
                .body("data['Hard disk size']", equalTo("1 TB"))
                .log().body();
    }
}
