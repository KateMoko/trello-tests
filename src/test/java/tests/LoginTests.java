package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.components.AuthenticatedHeaderComponent;

import static io.qameta.allure.Allure.step;

public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    AuthenticatedHeaderComponent headerComponent = new AuthenticatedHeaderComponent();

    @Test
    @DisplayName("User authorization with valid credentials")
    void successfulLoginTest() {
        step("Open login page", () ->
                loginPage.openPage()
        );

        step("Enter user credentials and click login", () ->
                loginPage.loginWithEmailAndPassword(userEmail, userPassword)
        );

        step("Check that header for authenticated user is visible", () ->
                headerComponent.verifyAuthenticatedHeaderIsVisible()
        );
    }
}