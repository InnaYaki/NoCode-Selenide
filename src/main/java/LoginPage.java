import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private  SelenideElement emailField = $ (By.id("sw-form-capture-email-input") );
    private  SelenideElement passwordField = $ (By.id("sw-form-password-input"));
    private SelenideElement signInButton = $ (By.id("sw-sign-in-submit-btn"));

    private SelenideElement signUpButton = $ (By.id("sw-go-to-sign-up-btn"));

    private SelenideElement errorMessage = $(byXpath("//div[@class='error-message login-error d-block']"));

    private SelenideElement forgotPasswordLink = $(byLinkText ("Forgot password"));

    private SelenideElement facebookLink = $(byCssSelector("[href*='facebook']"));

    private SelenideElement twitterLink = $(byCssSelector("[href*='twitter']"));

    private SelenideElement instagramLink = $(byCssSelector("[href*='instagram']"));

    @Step("Enter to email field")
    public void enterEmail (String emailTeacher) {
        emailField.shouldBe(visible, Duration.ofSeconds(10));
        emailField.setValue(emailTeacher);
    }
    @Step("Enter value to password field")
    public void enterPassword(String passwordValue) {
        passwordField.shouldBe(visible, Duration.ofSeconds(10));
        passwordField.setValue(passwordValue);
    }
    @Step("push sign In button")
    public void clickOnSignInButton() {
        signInButton.shouldBe(enabled);
        signInButton.click();
    }

    public void clickOnSignUpButton() {
        signUpButton.shouldBe(enabled);
        signUpButton.click();
    }


    public void checkTextErrorMessage(String errorTextValue) {
        errorMessage.shouldBe(visible, Duration.ofSeconds(10));
        errorMessage.shouldHave(text(errorTextValue));
    }
    public void emptyFields (String errorTextValue) {
        errorMessage.shouldBe(visible, Duration.ofSeconds(10));
        errorMessage.shouldHave(text(errorTextValue));
    }

    public void clickOnForgotPassword() {
        forgotPasswordLink.shouldBe(enabled);
        forgotPasswordLink.click();
    }

    public void facebookIsDisplayed   (){
        facebookLink.shouldBe(visible);
    }
    public void clickOnFacebookLink  (){
        facebookLink.shouldBe(enabled);
        facebookLink.click();
    }

    public void twitterIsDisplayed   (){twitterLink.shouldBe(visible);}
    public void clickOnTwitterLink  (){
        twitterLink.shouldBe(enabled);
        twitterLink.click();
    }

    public void instagramIsDisplayed   (){instagramLink.shouldBe(visible);}
    public void clickOnInstagramLink  (){
        instagramLink.shouldBe(enabled);
        instagramLink.click();
    }

}
