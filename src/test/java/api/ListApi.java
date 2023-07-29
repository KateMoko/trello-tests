package api;

import models.ListModel;

import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpec;
import static specs.Specs.responseCode200Spec;

public class ListApi {

    public ListModel createListWithNameOnBoardWithId(String listName, String boardId) {
        return given(requestSpec)
                .pathParam("idBoard", boardId)
                .queryParam("name", listName)
                .when()
                .post("/1/boards/{idBoard}/lists")
                .then()
                .spec(responseCode200Spec)
                .extract().as(ListModel.class);
    }
}