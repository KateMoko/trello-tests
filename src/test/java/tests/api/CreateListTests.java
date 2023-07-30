package tests.api;

import api.BoardApi;
import api.ListApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.BoardModel;
import models.ListModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api")
@Owner("EMoiseenko")
@Feature("Actions with lists")
@Story("Lists creation")
@DisplayName("Lists creation")
public class CreateListTests {

    @Test
    @DisplayName("Successful creation of a list in the board")
    void createListInBoardTest() {
        BoardApi boardApi = new BoardApi();
        RandomUtils randomUtils = new RandomUtils();
        String listName = randomUtils.getListName();

        BoardModel board = step("Create new board", () ->
                boardApi.createBoardWithName(randomUtils.getBoardName()));

        ListModel list = step("Send POST request to Create list in the board", () ->
                new ListApi().createListWithNameOnBoardWithId(listName, board.getId()));

        step("Check that the list was created in the specified board", () ->
                assertEquals(board.getId(), list.getIdBoard()));

        step("Verify the details of the created list", () -> {
            assertEquals(listName, list.getName());
            assertEquals(false, list.getClosed());
        });

        step("Delete created board", () ->
                boardApi.deleteBoardById(board.getId()));
    }
}