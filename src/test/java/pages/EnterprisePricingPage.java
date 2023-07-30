package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EnterprisePricingPage {

    private final SelenideElement pricingCalculatorSection = $("[data-testid='ui-pricing-calculator']"),
            numberOfUsersInput = $("input[data-testid='ui-pricing-calculator-input']"),
            monthlyPrice = $("[data-testid='ui-pricing-calculator-monthly-price']"),
            annualPrice = $("[data-testid='ui-pricing-calculator-annual-price']"),
            errorMessage = $("[data-testid='ui-pricing-calculator-error']"),
            acceptCookies = $("#onetrust-accept-btn-handler");

    @Step("Open Enterprise pricing page")
    public EnterprisePricingPage openPage() {
        open("/en/enterprise");
        pricingCalculatorSection.shouldBe(visible);
        acceptCookies.click();

        return this;
    }

    @Step("Check that number of users = {numberOfUsers}")
    public EnterprisePricingPage verifyNumberOfUsersValue(int numberOfUsers) {
        numberOfUsersInput.shouldHave(value(String.valueOf(numberOfUsers)));
        return this;
    }

    @Step("Enter number of users = {numberOfUsers}")
    public EnterprisePricingPage enterNumberOfUsers(int numberOfUsers) {
        pricingCalculatorSection.scrollIntoView(false);
        numberOfUsersInput.click();
        numberOfUsersInput.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
        numberOfUsersInput.sendKeys(String.valueOf(numberOfUsers));
        return this;
    }

    @Step("Verify that the monthly price is {price}")
    public EnterprisePricingPage verifyMonthlyPrice(String price) {
        monthlyPrice.shouldHave(text(price));
        return this;
    }

    @Step("Verify that the monthly price is not displayed")
    public EnterprisePricingPage verifyMonthlyPriceNotDisplayed() {
        monthlyPrice.shouldNotBe(visible);
        return this;
    }

    @Step("Verify that the annual price is {price}")
    public EnterprisePricingPage verifyAnnualPrice(String price) {
        annualPrice.shouldHave(text(price));
        return this;
    }

    @Step("Verify that the monthly price is not displayed")
    public EnterprisePricingPage verifyAnnualPriceNotDisplayed() {
        annualPrice.shouldNotBe(visible);
        return this;
    }

    @Step("Verify that the message '{message}' is displayed")
    public EnterprisePricingPage verifyErrorMessage(String message) {
        errorMessage.shouldHave(text(message));
        return this;
    }
}