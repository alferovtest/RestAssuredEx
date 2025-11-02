package playerControllerTests;

import controller.PlayerController;
import dto.player.PlayerDTO;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import base.BaseTest;


public class UpdatePlayerTests extends BaseTest {

    @Test(groups = {"Full Regression"}, description = "Update PLayer")
    public void updatePlayerTest() {

        // Here is builder example
        PlayerDTO player = PlayerDTO.builder()
                .age(56)
                .gender("male")
                .login("loginString")
                .password("passwordString")
                .role("admin")
                .screenName("newScreenName")
                .build();

        // Here is updatePlayer example
        PlayerController.updatePlayer(player, "admin", "123");
    }
}
