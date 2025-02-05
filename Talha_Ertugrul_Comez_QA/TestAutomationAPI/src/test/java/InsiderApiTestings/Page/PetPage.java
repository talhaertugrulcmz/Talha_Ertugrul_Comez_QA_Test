package InsiderApiTestings.Page;

import InsiderApiTestings.Page.BasePage;
import io.restassured.response.Response;

public class PetPage extends BasePage {

    // Endpoint for Pet operations
    public final String petEndpoint = "/pet";

    // Create a pet (POST)
    public Response createPet(String petJsonBody) {
        return sendPostRequest(petEndpoint, petJsonBody);
    }

    // Get a pet (GET)
    public Response getPetById(int petId) {
        return sendGetRequest(petEndpoint + "/" + petId);
    }

    // Update a pet (PUT)
    public Response updatePet(int petId, String petJsonBody) {
        return sendPutRequest(petEndpoint + "/" + petId, petJsonBody);
    }

    // Delete a pet (DELETE)
    public Response deletePet(int petId) {
        return sendDeleteRequest(petEndpoint + "/" + petId);
    }
}