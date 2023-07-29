package api;

import models.BoardModel;

import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpec;
import static specs.Specs.responseCode200Spec;

public class BoardApi {

    public BoardModel createBoardWithName(String boardName) {
        return given(requestSpec)
                .queryParam("name", boardName)
                .queryParam("defaultLists", false)
                .when()
                .post("/1/boards/")
                .then()
                .spec(responseCode200Spec)
                .extract().as(BoardModel.class);
    }

    public void deleteBoardById(String boardId) {
        given(requestSpec)
                .pathParam("id", boardId)
                .when()
                .delete("/1/boards/{id}")
                .then()
                .spec(responseCode200Spec);
    }
}