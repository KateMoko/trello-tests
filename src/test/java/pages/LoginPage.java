package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement userEmailInput = $("#username"),
            continueButton = $("#login-submit"),
            passwordInput = $("#password"),
            loginButton = $("#login-submit");

    public LoginPage openPage() {
        open("/login");
        userEmailInput.shouldBe(Condition.interactable);
        return this;
    }

    public void loginWithEmailAndPassword(String email, String password) {
        userEmailInput.setValue(email);
        continueButton.click();
        passwordInput.setValue(password);
        loginButton.click();
    }
}