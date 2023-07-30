package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${env}.properties"
})
public interface ApiConfig extends Config{
    @Key("apiBaseUrl")
    @DefaultValue("https://api.trello.com")
    String getApiBaseUrl();

    @Key("trelloApiKey")
    String getTrelloApiKey();

    @Key("trelloApiToken")
    String getTrelloApiToken();
}
