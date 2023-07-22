package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${env}.properties"
})
public interface TestConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://trello.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean getIsRemote();

    @Key("selenoidUrl")
    String getSelenoidUrl();

    @Key("selenoidLogin")
    String getSelenoidLogin();

    @Key("selenoidPassword")
    String getSelenoidPassword();

    @Key("trelloUserEmail")
    String getTrelloUserEmail();

    @Key("trelloUserPassword")
    String getTrelloUserPassword();
}