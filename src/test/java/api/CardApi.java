package api;

import models.CardModel;

import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpec;
import static specs.Specs.responseCode200Spec;

public class CardApi {

    public CardModel createCardWithNameOnListWithId(String cardName, String listId) {
        return given(requestSpec)
                .queryParam("idList", listId)
                .queryParam("name", cardName)
                .when()
                .post("/1/cards")
                .then()
                .spec(responseCode200Spec)
                .extract().as(CardModel.class);
    }
}