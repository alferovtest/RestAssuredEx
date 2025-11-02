package playerControllerTests;

import dto.player.PlayerDTO;
import dto.player.PlayerGetDeleteByPlayerIdRequestDTO;
import helpers.Util;
import controller.PlayerController;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.HashMap;

public class CreatePlayerTests extends BaseTest {

    @Test(groups = {"Priority 0", "Priority 1", "Full Regression"}, dataProvider = "editor", description = "Create PLayer")
    public void createPlayerTest(String editor) {

        Integer random = Util.generateSixDigitNumber();

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("age", "45");
        parameters.put("editor", editor);
        parameters.put("gender", "male");
        parameters.put("login", "login" + random);
        parameters.put("password", "pass" + random);
        parameters.put("role", editor);
        parameters.put("screenName", "screenName" + random);

        Response response =  PlayerController.createPlayer(parameters, editor);
        Assert.assertNotEquals(response.getBody().asPrettyString(), "", "Body is empty, should return JSON");
        SOFTLY.get().assertEquals(response.statusCode(), 200);
        SOFTLY.get().assertAll();

        // delete player by ID
        PlayerDTO playerCreated = response.as(PlayerDTO.class);
        PlayerGetDeleteByPlayerIdRequestDTO idRequestDTO = new PlayerGetDeleteByPlayerIdRequestDTO();
        idRequestDTO.setPlayerId(playerCreated.getId());
        PlayerController.deletePlayer("admin", idRequestDTO);
    }

    @DataProvider(name = "editor")
    private Object[][] editor() {
        return new Object[][]{
                {"admin"},
                {"supervisor"}
        };
    }
}
