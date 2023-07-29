package tests.api;

import api.BoardApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.BoardModel;
import models.ErrorModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.*;

@Tag("api")
@Owner("EMoiseenko")
@Feature("Actions with boards")
@Story("Boards creation")
@DisplayName("Boards creation")
public class CreateBoardTests {

    @Test
    @DisplayName("Successful board creation")
    void successfulBoardCreationTests() {
        BoardApi boardApi = new BoardApi();
        String boardName = new RandomUtils().getBoardName();

        BoardModel board = step("Send POST request to Create new board", () ->
                boardApi.createBoardWithName(boardName));

        step("Check name of created board", () ->
                assertEquals(boardName, board.getName()));

        step("Check that created board is not closed", () ->
                assertEquals(false, board.getClosed()));

        step("Delete created board", () ->
                boardApi.deleteBoardById(board.getId()));
    }

    @Test
    @DisplayName("Check if a board cannot be created without specifying its name")
    void createNewBoardWithoutBoardName() {
        ErrorModel error = step("Send POST request to create board without board name", () ->
                given(requestSpec)
                        .when()
                        .post("/1/boards/")
                        .then()
                        .spec(responseCode400Spec)
                        .extract().as(ErrorModel.class));

        step("Check error message", () ->
                assertEquals("invalid value for name", error.getMessage()));
    }
}