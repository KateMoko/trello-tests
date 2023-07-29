package specs;

import config.ApiConfig;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.CredentialsModel;
import org.aeonbits.owner.ConfigFactory;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class Specs {
    private static final ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
    private static final CredentialsModel credentials = new CredentialsModel();

    static {
        credentials.setKey(apiConfig.getTrelloApiKey());
        credentials.setToken(apiConfig.getTrelloApiToken());
    }

    public static RequestSpecification requestSpec = with()
            .baseUri(apiConfig.getApiBaseUrl())
            .body(credentials)
            .accept("*/*")
            .contentType(JSON)
            .log().uri()
            .filter(withCustomTemplates());

    public static ResponseSpecification responseCode200Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification responseCode400Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(400)
            .build();

    public static ResponseSpecification responseCode404Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(404)
            .build();
}