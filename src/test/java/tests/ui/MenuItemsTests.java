package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Tag("ui")
@Owner("EMoiseenko")
@Feature("Main page")
@DisplayName("Main page menu items")
public class MenuItemsTests extends TestBase {

    MainPage mainPage = new MainPage();

    static Stream<Arguments> menuItemsTestDataProvider() {
        return Stream.of(
                Arguments.of(
                        "Features", List.of("Views", "Automation", "Power-Ups", "Templates", "Integrations")
                ),
                Arguments.of("Solutions", List.of("Marketing teams", "Product management", "Engineering teams",
                        "Design teams", "Startups", "Remote teams", "Use case: Task management", "Use case: Resource hub",
                        "Use case: Project management")
                ),
                Arguments.of("Plans", List.of("Standard", "Premium", "Enterprise")
                ),
                Arguments.of("Resources", List.of("Trello guide", "Remote work guide", "Webinars",
                        "Customer stories", "Developers", "Help resources")
                )
        );
    }

    @Story("Main page menu")
    @DisplayName("Menu sub-items verification:")
    @MethodSource("menuItemsTestDataProvider")
    @ParameterizedTest(name = "For the {0} menu item following sub-items are displayed: {1}")
    void menuItemsTest(String menuItem, List<String> menuSubItems) {
        step("Open main page", () ->
                mainPage.openPage());

        step("Click on the menu item", () ->
                mainPage.openMenuItemWithName(menuItem));

        step("Verify menu sub-items", () ->
                mainPage.verifyMenuSubItems(menuSubItems));
    }
}