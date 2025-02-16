package org.example;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteTest {
    @Test
    public void testDeleteObject() {
        String objectId = "ff808181932badb601950e0097ed37ad";  // ID of the object to delete

        // Given
        given()
                .baseUri("https://api.restful-api.dev")

                // When
                .when()
                .delete("/objects/" + objectId)

                // Then
                .then()
                .statusCode(200)
                .body("message", containsString("Object with id = " + objectId + " has been deleted"))
                .log().body();
    }
}
