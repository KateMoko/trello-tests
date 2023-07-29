package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthenticatedHeaderComponent {

    private final SelenideElement header = $("[data-testid='authenticated-header']"),
            userIconButton = $("[data-testid='header-member-menu-button']"),
            menuAccountSection = $("[data-testid='account-menu-account-section']");

    public AuthenticatedHeaderComponent verifyAuthenticatedHeaderIsVisible() {
        header.shouldBe(visible);
        return this;
    }

    public AuthenticatedHeaderComponent verifyUserEmailDisplayedInMenu(String userEmail) {
        userIconButton.click();
        menuAccountSection.shouldHave(text(userEmail));
        userIconButton.click();
        return this;
    }
}