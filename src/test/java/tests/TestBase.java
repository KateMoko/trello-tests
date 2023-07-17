package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    private static final TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());
    String userEmail = config.getTrelloUserEmail();
    String userPassword = config.getTrelloUserPassword();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = "1920x1080";

        if (config.getIsRemote()) {
            Configuration.remote = config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Last step screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (config.getIsRemote())
            Attach.addVideo();

//        closeWebDriver();
    }
}