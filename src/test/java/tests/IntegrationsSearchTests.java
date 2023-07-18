package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.IntegrationsPage;

@Tag("ui")
@Feature("Searching for integrations")
@Story("Search integrations by integration name and description")

public class IntegrationsSearchTests extends TestBase {
    IntegrationsPage integrationsPage = new IntegrationsPage();

    @Test
    @DisplayName("Check the search results for the specified integration name")
    void checkSearchByNameResult() {
        String searchQuery = "slack";
        String[] resultIntegrations = {"Slack Power-Up", "Slack"};

        integrationsPage.openPage()
                .fillSearchField(searchQuery)
                .verifyIntegrationsList(resultIntegrations);
    }

    @Test
    @DisplayName("Verify message when no results are matching the search query")
    void checkNoSearchResultMessage() {
        String searchQuery = "~qwer1234";
        String expectedMessage = "We're sorry, we can’t find any results for your search";

        integrationsPage.openPage()
                .fillSearchField(searchQuery)
                .verifyNoResultsMessage(expectedMessage);
    }
}