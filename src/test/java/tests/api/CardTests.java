package tests.api;

import api.BoardApi;
import api.CardApi;
import api.ListApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import models.BoardModel;
import models.CardModel;
import models.ListModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.requestSpec;
import static specs.Specs.responseCode200Spec;

@Tag("api")
@Owner("EMoiseenko")
@Feature("Actions with cards")
@DisplayName("Creating and editing cards")
public class CardTests {

    BoardApi boardApi = new BoardApi();
    ListApi listApi = new ListApi();
    CardApi cardApi = new CardApi();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    @DisplayName("Successful creation of a card in the list")
    void createCardTests() {
        String cardName = randomUtils.getCardName();

        BoardModel board = step("Create new board", () ->
                boardApi.createBoardWithName(randomUtils.getBoardName()));

        ListModel list = step("Create list in the board", () ->
                listApi.createListWithNameOnBoardWithId(randomUtils.getListName(), board.getId()));

        CardModel card = step("Send POST request to create card in the list", () ->
                cardApi.createCardWithNameOnListWithId(cardName, list.getId()));

        step("Check that card was created in the specified list", () ->
                assertEquals(list.getId(), card.getIdList()));

        step("Check that card was created in the desired board", () ->
                assertEquals(board.getId(), card.getIdBoard()));

        step("Verify the details of the created card", () -> {
            assertEquals(cardName, card.getName());
            assertEquals(false, card.getClosed());
        });

        step("Delete created board", () ->
                boardApi.deleteBoardById(board.getId()));
    }

    @Test
    @DisplayName("Card update: moving the card to another list")
    void moveCardToAnotherListTest() {
        String cardName = randomUtils.getCardName();

        BoardModel board = step("Create new board", () ->
                boardApi.createBoardWithName(randomUtils.getBoardName()));

        ListModel firstList = step("Create first list in the board", () ->
                listApi.createListWithNameOnBoardWithId(randomUtils.getListName(), board.getId()));

        ListModel secondList = step("Create second list in the board", () ->
                listApi.createListWithNameOnBoardWithId(randomUtils.getListName(), board.getId()));

        String cardId = step("Create card in the first list", () ->
                cardApi.createCardWithNameOnListWithId(cardName, firstList.getId())).getId();

        CardModel updatedCard = step("Send PUT request to update card: move the card to the second list", () ->
                given(requestSpec)
                        .pathParam("id", cardId)
                        .queryParam("idList", secondList.getId())
                        .when()
                        .put("/1/cards/{id}")
                        .then()
                        .spec(responseCode200Spec)
                        .extract().as(CardModel.class));

        step("Check that card was moved in the second list", () ->
                assertEquals(secondList.getId(), updatedCard.getIdList()));

        step("Check that the card name has not changed", () ->
                assertEquals(cardName, updatedCard.getName()));

        step("Delete created board", () ->
                boardApi.deleteBoardById(board.getId()));
    }
}