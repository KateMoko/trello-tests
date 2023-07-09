package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SampleTest extends TestBase {

    @Test
    void justTryItTest() {
        step("log in", () -> {
            open("/en/login");
            $("h1").shouldHave(text("Log in to Trello"));
            $("#user").setValue("katnotif@gmail.com");
            $("#login").click();
            $("#password").setValue("ig;Ck?mi2bUA$gV");
            $("#login-submit").click();
            $("[data-testid='header-member-menu-button']").should(visible);
        });
    }
}