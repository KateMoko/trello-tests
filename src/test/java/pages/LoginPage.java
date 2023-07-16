package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement userEmailInput = $("#user"),
            continueButton = $("#login"),
            passwordInput = $("#password"),
            loginButton = $("#login-submit");

    public LoginPage openPage() {
        open("/en/login");
        return this;
    }

    public void loginWithEmailAndPassword(String email, String password) {
        userEmailInput.setValue(email);
        continueButton.click();
        passwordInput.setValue(password);
        loginButton.click();
    }
}