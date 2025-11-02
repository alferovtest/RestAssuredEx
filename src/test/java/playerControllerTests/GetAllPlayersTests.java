package playerControllerTests;

import controller.PlayerController;
import dto.player.PlayerGetAllPlayersResponseDTO;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import base.BaseTest;


public class GetAllPlayersTests extends BaseTest {

    @Test(groups = {"Priority 1", "Full Regression"}, description = "Get All Players")
    public void getAllPlayers() {
        Response response = PlayerController.getAllPlayers();
        PlayerGetAllPlayersResponseDTO responseDTO = response.as(PlayerGetAllPlayersResponseDTO.class);
        SOFTLY.get().assertEquals(response.statusCode(), 200);
        SOFTLY.get().assertFalse(responseDTO.getPlayers().isEmpty());
        SOFTLY.get().assertAll();
    }
}
