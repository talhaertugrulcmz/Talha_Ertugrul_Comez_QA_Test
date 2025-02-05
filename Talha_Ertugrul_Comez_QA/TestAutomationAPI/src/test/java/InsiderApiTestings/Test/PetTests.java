package InsiderApiTestings.Test;

import InsiderApiTestings.Page.PetPage;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class PetTests{

    public PetPage petPage;
    public int petId = 12345; // Example pet ID for testing

    @BeforeClass
    public void setup() {
        petPage = new PetPage();
    }

    // Positive Test Case: Create Pet
    @Test
    public void testCreatePet() {
        String petJsonBody = "{\n" +
                "  \"id\": 12345,\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"status\": \"available\"\n" +
                "}";

        Response response = petPage.createPet(petJsonBody);
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("doggie"));
    }

    // Positive Test Case: Get Pet
    @Test
    public void testGetPet() {
        Response response = petPage.getPetById(petId);
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("doggie"));
    }

    // Negative Test Case: Get Pet with Invalid ID
    @Test
    public void testGetPetInvalidId() {
        int invalidPetId = 99999;
        Response response = petPage.getPetById(invalidPetId);
        assertEquals(404, response.getStatusCode());
    }

    // Positive Test Case: Update Pet
    @Test
    public void testUpdatePet() {
        String updatedPetJsonBody = "{\n" +
                "  \"id\": 12345,\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"status\": \"sold\"\n" +
                "}";

        Response response = petPage.updatePet(petId, updatedPetJsonBody);
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("sold"));
    }

    // Negative Test Case: Delete Pet
    @Test
    public void testDeletePet() {
        Response response = petPage.deletePet(petId);
        assertEquals(200, response.getStatusCode());

        // Verifying that the pet is deleted
        response = petPage.getPetById(petId);
        assertEquals(404, response.getStatusCode());
    }
}