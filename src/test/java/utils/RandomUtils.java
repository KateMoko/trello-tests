package utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    private final Faker faker = new Faker();
    private static final String[] listNames = {"Project Resources", "Questions For Next Meeting", "To Do", "Pending",
            "Blocked", "Done"};

    public String getBoardName() {
        return faker.leagueOfLegends().location();
    }

    public String getListName() {
        return faker.options().option(listNames);
    }

    public String getCardName() {
        return faker.leagueOfLegends().quote();
    }
}