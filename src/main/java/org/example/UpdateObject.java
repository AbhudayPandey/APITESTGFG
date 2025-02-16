package org.example;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateObject {
    @Test
    public void testUpdateObject() {

        String payload = """
        {
           "name": "Apple MacBook Pro 16",
           "data": {
              "year": 2019,
              "price": 2049.99,
              "CPU model": "Intel Core i9",
              "Hard disk size": "1 TB",
              "color": "silver"
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
                .put("/objects/ff808181932badb60195099384cd340c")

                // Then
                .then()
                .statusCode(200)
                .body("name", equalTo("Apple MacBook Pro 16"))
                .body("data.year", equalTo(2019))
                .body("data.price", equalTo(2049.99f))
                .body("data['CPU model']", equalTo("Intel Core i9"))
                .body("data['Hard disk size']", equalTo("1 TB"))
                .body("data.color", equalTo("silver"))
                .log().body();
    }
}
