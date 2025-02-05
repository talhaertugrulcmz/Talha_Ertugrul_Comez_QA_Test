package InsiderApiTestings.Page;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasePage {

    public RequestSpecification request;
    protected String baseURI = "https://petstore.swagger.io/v2";

    public BasePage() {
        RestAssured.baseURI = baseURI;
        request = RestAssured.given();
    }

    // Set common headers
    public BasePage setHeaders() {
        request.header("Content-Type", "application/json");
        return this;
    }

    // Send GET request
    public Response sendGetRequest(String endpoint) {
        return request.get(endpoint);
    }

    // Send POST request
    public Response sendPostRequest(String endpoint, String body) {
        return request.body(body).post(endpoint);
    }

    // Send PUT request
    public Response sendPutRequest(String endpoint, String body) {
        return request.body(body).put(endpoint);
    }

    // Send DELETE request
    public Response sendDeleteRequest(String endpoint) {
        return request.delete(endpoint);
    }
}