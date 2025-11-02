package playerControllerTests;

import controller.PlayerController;
import dto.player.PlayerDTO;
import dto.player.PlayerGetAllPlayersResponseDTO;
import dto.player.PlayerGetDeleteByPlayerIdRequestDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.List;


public class DeletePlayerTests extends BaseTest {

    @Test(groups = "Full Regression", description = "Delete player by ID")
    public void deletePlayer() {

        // Just for setup to delete user (Getting player ID for age=55 NOT good solution)
        // HERE SHOULD BE CREATE USER ACTION FOR TEST INSTEAD THIS
        Response responseAll = PlayerController.getAllPlayers();
        PlayerGetAllPlayersResponseDTO responseDTO = responseAll.as(PlayerGetAllPlayersResponseDTO.class);
        List<PlayerDTO> players = responseDTO.getPlayers();
        Integer playerID = players.stream().filter(playerDTO -> playerDTO.getAge() == 55).findFirst().get().getId();


        PlayerGetDeleteByPlayerIdRequestDTO playerGetDeleteByPlayerIdRequestDTO = new PlayerGetDeleteByPlayerIdRequestDTO();
        playerGetDeleteByPlayerIdRequestDTO.setPlayerId(playerID);
        Response response = PlayerController.deletePlayer("admin", playerGetDeleteByPlayerIdRequestDTO);
        Assert.assertNotEquals(response.getBody().asPrettyString(), "", "Body is empty, should return JSON");
        SOFTLY.get().assertEquals(response.getBody().jsonPath().get("body"), "");
        SOFTLY.get().assertEquals(response.getBody().jsonPath().get("statusCode"), "100 CONTINUE");
        SOFTLY.get().assertEquals(response.getBody().jsonPath().get("statusCodeValue"), "0");
        SOFTLY.get().assertAll();
    }

    @Test(groups = "Full Regression", description = "Delete player by invalid ID")
    public void deletePlayerInvalidIDTest() {
        PlayerGetDeleteByPlayerIdRequestDTO playerGetDeleteByPlayerIdRequestDTO = new PlayerGetDeleteByPlayerIdRequestDTO();
        playerGetDeleteByPlayerIdRequestDTO.setPlayerId(111111111);
        Response response = PlayerController.deletePlayer("admin", playerGetDeleteByPlayerIdRequestDTO);
        Assert.assertNotEquals(response.getBody().asPrettyString(), "", "Body is empty, should return JSON");
        SOFTLY.get().assertEquals(response.getBody().jsonPath().get("body"), "");
        SOFTLY.get().assertEquals(response.getBody().jsonPath().get("statusCode"), "100 CONTINUE");
        SOFTLY.get().assertEquals(response.getBody().jsonPath().get("statusCodeValue"), "0");
        SOFTLY.get().assertAll();
    }
}
