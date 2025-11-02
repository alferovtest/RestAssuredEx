package playerControllerTests;

import controller.PlayerController;
import dto.player.PlayerDTO;
import dto.player.PlayerGetDeleteByPlayerIdRequestDTO;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import base.BaseTest;

public class GetPlayerTests extends BaseTest {

    @Test(groups = {"Priority 0", "Priority 1", "Full Regression"}, description = "Get player by ID")
    public void getPlayerTest() {
        PlayerGetDeleteByPlayerIdRequestDTO playerGetRequestDTO = new PlayerGetDeleteByPlayerIdRequestDTO();
        playerGetRequestDTO.setPlayerId(1);
        Response response = PlayerController.getPlayer(playerGetRequestDTO);
        PlayerDTO responseDTO = response.as(PlayerDTO.class);
        SOFTLY.get().assertEquals(response.statusCode(), 200);
        SOFTLY.get().assertEquals(responseDTO.getId(), playerGetRequestDTO.getPlayerId());
        SOFTLY.get().assertEquals(responseDTO.getRole(), "supervisor");
        SOFTLY.get().assertAll();
    }

    @Test(groups = "Full Regression", description = "Get player by ID - negative scenario")
    public void getPlayerInvalidIDTest() {
        PlayerGetDeleteByPlayerIdRequestDTO playerGetRequestDTO = new PlayerGetDeleteByPlayerIdRequestDTO();
        playerGetRequestDTO.setPlayerId(1000);
        Response response = PlayerController.getPlayer(playerGetRequestDTO);
        SOFTLY.get().assertEquals(response.body().asString(), "");
        SOFTLY.get().assertEquals(response.statusCode(), 200);
        SOFTLY.get().assertAll();
    }
}
