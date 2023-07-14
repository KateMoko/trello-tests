package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.EnterprisePricingPage;

@Tag("web")
@Feature("Pricing")
@Story("Enterprise pricing calculator")
public class EnterprisePricingTests extends TestBase{

    EnterprisePricingPage enterprisePricingPage = new EnterprisePricingPage();

    @Test
    @DisplayName("Checking prices for a minimum number of users")
    void checkPricesForMinimumNumberOfUsers(){
        int numberOfUsers = 50;
        String expectedMonthlyPrice = "$17.50USD",
                expectedAnnualPrice = "$10,500USD";

        enterprisePricingPage.openPage()
                .enterNumberOfUsers(numberOfUsers)
                .verifyMonthlyPrice(expectedMonthlyPrice)
                .verifyAnnualPrice(expectedAnnualPrice);
    }

    @Test
    @DisplayName("Checking prices for a maximum number of users")
    void checkPricesForMaximumNumberOfUsers(){
        int numberOfUsers = 10000000;
        String expectedMonthlyPrice = "$2.51USD",
                expectedAnnualPrice = "$300,742,500USD";

        enterprisePricingPage.openPage()
                .enterNumberOfUsers(numberOfUsers)
                .verifyMonthlyPrice(expectedMonthlyPrice)
                .verifyAnnualPrice(expectedAnnualPrice);
    }

    @Test
    @DisplayName("Checking the error message when number of users is less than minimum")
    void checkErrorForLessThanMinimumUsers(){
        int numberOfUsers = 49;
        String expectedMessage = "50 user minimum";

        enterprisePricingPage.openPage()
                .enterNumberOfUsers(numberOfUsers)
                .verifyErrorMessage(expectedMessage)
                .verifyMonthlyPriceNotDisplayed()
                .verifyAnnualPriceNotDisplayed();
    }

    @Test
    @DisplayName("Checking the error message when number of users is more than maximum")
    void checkErrorForMoreThanMaximumUsers(){
        int numberOfUsers = 10000001;
        String expectedMessage = "10,000,000 user maximum";

        enterprisePricingPage.openPage()
                .enterNumberOfUsers(numberOfUsers)
                .verifyErrorMessage(expectedMessage)
                .verifyMonthlyPriceNotDisplayed()
                .verifyAnnualPriceNotDisplayed();
    }
}