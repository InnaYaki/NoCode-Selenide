import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public SelenideElement dropdown = $ (By.className("bootstrap-select"));

    public SelenideElement roleTeacher= $ (byId("bs-select-1-0"));



    public SelenideElement fullName = $(byId("sw-form-capture-full_name-input"));


    private  SelenideElement emailFieldReg = $ (By.id("sw-form-capture-email-input") );

    private  SelenideElement passwordFieldReg = $ (By.id("sw-form-password-input"));

    private SelenideElement checkBox = $ (
            By.xpath("//span[@class ='checkmark position-relative sw-checkbox']"));

    private SelenideElement signUpButton = $ (By.id("sw-sign-up-submit-btn"));

    private SelenideElement errorMessageSignUpButton = $ (By.cssSelector
            ("[class='error-message required-errors d-block']"));





    public void clickOnDropDown (){
        dropdown.shouldBe(visible,Duration.ofSeconds(10));
        dropdown.click();
    }

    public void enterRoleTeacher () {
        roleTeacher.shouldBe(visible, Duration.ofSeconds(10));
        roleTeacher.click();
    }

    public void enterFullName (String fullNameText) {
        fullName.shouldBe(visible, Duration.ofSeconds(10));
        fullName.setValue(fullNameText);
    }

    public void enterEmailReg (String emailTeacher) {
        emailFieldReg.shouldBe(visible, Duration.ofSeconds(10));
        emailFieldReg.setValue(emailTeacher);
    }

    public void enterPasswordFieldReg (String passwordValue) {
        passwordFieldReg.shouldBe(visible, Duration.ofSeconds(10));
        passwordFieldReg.setValue(passwordValue);
    }

    public void clickOnCheckBox() {
        checkBox.shouldBe(enabled);
        checkBox.click();
    }

    public void clickOnSignUpButton() {
        signUpButton.shouldBe(enabled);
        signUpButton.click();
    }
    public void checkTextErrorMessage(String errorTextValue) {
        errorMessageSignUpButton.shouldBe(visible, Duration.ofSeconds(10));
        errorMessageSignUpButton.shouldHave(text(errorTextValue));

    }










}
