package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement formHeader = $("h1"),
            userEmailInput = $("#user"),
            continueButton = $("#login"),
            passwordInput = $("#password"),
            loginButton = $("#login-submit");

    public LoginPage openPage() {
        open("/login");
        formHeader.shouldHave(text("Log in to Trello"));

        return this;
    }

    public void loginWithEmailAndPassword(String email, String password) {
        userEmailInput.setValue(email);
        continueButton.click();
        passwordInput.setValue(password);
        loginButton.click();
    }
}