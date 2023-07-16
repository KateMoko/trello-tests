package pages;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public MainPage openPage() {
        open("/en");
        return this;
    }

    public MainPage openMenuItemWithName(String menuItem) {
        $(byTagAndText("button", menuItem)).shouldBe(interactable).click();
        return this;
    }

    public void verifyMenuSubItems(List<String> menuSubItems) {
        $$("a[data-testid='ui-nav-link'] p[class^='UiNavLinkstyles__NavLinkTitle'")
                .filter(visible)
                .shouldHave(texts(menuSubItems));
    }
}