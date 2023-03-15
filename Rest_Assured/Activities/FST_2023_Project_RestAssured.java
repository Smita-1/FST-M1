package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class FST_2023_Project_RestAssured {
    // Declare request specification
    RequestSpecification requestSpec;
    String SSH_KEY = "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";
    int id = ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIEp3b70jBPwhj+hlXYd8rkWMI73kMTkKW3/7y4Mfcl5G gmx\07003i744@IBM-PF3JXQFW;
    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                // Set base URL
                .setBaseUri("https://api.github.com")
                // Build request specification
                .build();
        @Test(priority=1)
        public void addNewPet() {
            // Create JSON request
            String reqBody = "{"
                "\"title"\": "TestAPIKey"
                  +  "\"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIEp3b70jBPwhj+hlXYd8rkWMI73kMTkKW3/7y4Mfcl5G gmx\\07003i744@IBM-PF3JXQFW\\";
            "}"


            Response response =
                    given().contentType(ContentType.JSON) // Set headers
                            .body(reqBody) // Add request body
                            .when().post("https://api.github.com/user/keys/{keyId}"); // Send POST request

            // Assertion
            response.then().body("id", equalTo(77232));
            response.then().body("name", equalTo("Riley"));
            response.then().body("status", equalTo("alive"));
        }

        @Test(priority=2)
        public void getPetInfo() {
            Response response =
                    given().contentType(ContentType.JSON) // Set headers
                            .when().pathParam("petId", "77232") // Set path parameter
                            .get(ROOT_URI + "/{petId}"); // Send GET request

            // Assertion
            response.then().body("id", equalTo(77232));
            response.then().body("name", equalTo("Riley"));
            response.then().body("status", equalTo("alive"));
        }

        @Test(priority=3)
        public void deletePet() {
            Response response =
                    given().contentType(ContentType.JSON) // Set headers
                            .when().pathParam("petId", "77232") // Set path parameter
                            .delete(ROOT_URI + "/{petId}"); // Send DELETE request

            // Assertion
            response.then().body("code", equalTo(200));
            response.then().body("message", equalTo("77232"));
        }
}
