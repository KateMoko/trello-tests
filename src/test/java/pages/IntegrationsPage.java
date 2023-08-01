package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.exactTextsCaseSensitiveInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class IntegrationsPage {

    private final SelenideElement integrationsSection = $("[data-testid='integration-section']"),
            searchIntegrationInput = $("div[class^='grid__Container'] input[type='search']"),
            noSearchResultsMessage = $(".noSearchResults");

    private final ElementsCollection integrationsList = $$("h3[id^='integration_title']").filter(visible);

    @Step("Open Integrations page")
    public IntegrationsPage openPage() {
        open("/en/integrations");
        integrationsSection.shouldBe(visible);
        return this;
    }

    @Step("Set value '{searchItem}' in the integration search field")
    public IntegrationsPage fillSearchField(String searchItem) {
        searchIntegrationInput.setValue(searchItem);
        return this;
    }

    @Step("Check that the following integrations are displayed: {strings}")
    public IntegrationsPage verifyIntegrationsList(String... strings) {
        integrationsList.shouldHave(exactTextsCaseSensitiveInAnyOrder(strings));
        return this;
    }

    @Step("Check that message '{message}' is displayed")
    public IntegrationsPage verifyNoResultsMessage(String message) {
        noSearchResultsMessage.shouldBe(visible).shouldHave(text(message));
        return this;
    }
}