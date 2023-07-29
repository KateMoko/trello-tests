package utils;

import net.datafaker.Faker;

public class RandomUtils {

    private final Faker faker = new Faker();
    private static final String[] listNames = {"Project Resources", "Questions For Next Meeting", "To Do", "Pending",
            "Blocked", "Done"};

    public String getBoardName() {
        return faker.dessert().flavor() + " " + faker.dessert().variety();
    }

    public String getListName() {
        return faker.options().option(listNames);
    }

    public String getCardName() {
        return faker.appliance().equipment() + faker.emoji().smiley();
    }
}