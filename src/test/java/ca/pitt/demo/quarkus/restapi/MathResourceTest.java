package ca.pitt.demo.quarkus.restapi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MathResourceTest {

    @Test
    public void testEvaluateEndpoint() {
        given()
          .when().get("/math?x=10&y=5")
          .then()
             .statusCode(200)
             .body(is("10.0 x 5.0 = 50.0"));
    }

}