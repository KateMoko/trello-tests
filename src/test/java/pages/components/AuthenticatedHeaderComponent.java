package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthenticatedHeaderComponent {

    private final SelenideElement header = $("[data-testid='authenticated-header']"),
            userIconButton = $("[data-testid='header-member-menu-button']"),
            logoutButton = $("[data-testid='account-menu-logout']");

    public void verifyAuthenticatedHeaderIsVisible(){
        header.shouldBe(visible);
    }

    public void logOut(){
        userIconButton.click();
        logoutButton.click();
    }
}
