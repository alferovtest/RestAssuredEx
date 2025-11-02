package controller;

import dto.player.PlayerDTO;
import dto.player.PlayerGetDeleteByPlayerIdRequestDTO;
import io.restassured.response.Response;
import spec.MainRequestSpecification;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class PlayerController {

    public static Response getPlayer(PlayerGetDeleteByPlayerIdRequestDTO playerGetDeleteByPlayerIdRequestDTO) {
        return given().spec(MainRequestSpecification.getRequestSpec())
                .body(playerGetDeleteByPlayerIdRequestDTO)
                .when()
                .post("/player/get");
    }

    public static Response deletePlayer(String editor, PlayerGetDeleteByPlayerIdRequestDTO playerGetDeleteByPlayerIdRequestDTO) {
        return given().spec(MainRequestSpecification.getRequestSpec())
                .body(playerGetDeleteByPlayerIdRequestDTO)
                .when()
                .delete("/player/delete/" + editor);
    }

    public static Response getAllPlayers() {
        return given().spec(MainRequestSpecification.getRequestSpec())
                .when()
                .get("/player/get/all");
    }

    public static Response createPlayer(HashMap<String, String> parameters, String editor) {
        return given().spec(MainRequestSpecification.getRequestSpec())
                .queryParams(parameters)
                .when()
                .get("/player/create/" + editor);
    }

    public static Response updatePlayer(PlayerDTO player, String editor, String id) {
        return given().spec(MainRequestSpecification.getRequestSpec())
                .body(player)
                .when()
                .patch("/player/update/" + editor + "/" + id);
    }
}
