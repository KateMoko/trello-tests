package tests.api;

import api.BoardApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.BoardModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.Specs.*;

@Tag("api")
@Owner("EMoiseenko")
@Feature("Actions with boards")
@Story("Deleting boards")
@DisplayName("Deleting boards")
public class DeleteBoardTests {

    @Disabled("There is an error on the application side")
    @Test
    @DisplayName("Successful deletion of the board")
    void boardDeletionTest() {
        BoardApi boardApi = new BoardApi();

        BoardModel board = step("Create new board", () ->
                boardApi.createBoardWithName(new RandomUtils().getBoardName()));

        step("Send DELETE request to delete board", () ->
                boardApi.deleteBoardById(board.getId()));

        step("Verify that a 404 code is returned in response to GET request for deleted item", () -> {
            given(requestSpec)
                    .pathParam("id", board.getId())
                    .when()
                    .get("/1/boards/{id}")
                    .then()
                    .spec(responseCode404Spec);
        });
    }
}
