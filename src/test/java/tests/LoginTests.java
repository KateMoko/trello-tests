package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.components.AuthenticatedHeaderComponent;

import static io.qameta.allure.Allure.step;

@Tag("ui")
@Feature("Authorization")
public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    AuthenticatedHeaderComponent headerComponent = new AuthenticatedHeaderComponent();

    @Story("Authorization with email and password")
    @Test
    @DisplayName("Successful authorization with valid email and password credentials")
    void successfulLoginTest() {
        step("Open login page", () ->
                loginPage.openPage()
        );

        step("Enter user credentials and click the login button", () ->
                loginPage.loginWithEmailAndPassword(userEmail, userPassword)
        );

        step("Check that the user's email is displayed in the account menu", () -> {
            headerComponent.verifyAuthenticatedHeaderIsVisible()
                    .verifyUserEmailDisplayedInMenu(userEmail);
        });
    }
}