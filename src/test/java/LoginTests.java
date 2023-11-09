import jdk.jfr.Description;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.codeborne.selenide.Selenide.sleep;

public class LoginTests extends BaseTest {

    @Test
    @Description("success Login with valid data as a teacher")
    public void successLogin() {

        loginPage.enterEmail("roxanne@example.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnSignInButton();
        dashboardPage.dashboardPageIsOpen();
    }

    @Test
    @Description("invalid Password")
    public void invalidPassword() {

        loginPage.enterEmail("roxanne@example.com");
        loginPage.enterPassword("987654");
        loginPage.clickOnSignInButton();
        loginPage.checkTextErrorMessage("Invalid email or password");
    }

    @Test @ Description ("empty Fields")
    public void emptyFields(){
        loginPage.clickOnSignInButton();
        loginPage.checkTextErrorMessage("Invalid email or password");
        loginPage.emptyFields("Invalid email or password");
    }

    @Test @ Description ("push the link of Forgot Password")
    public void clickOnForgotPassword(){
        loginPage.clickOnForgotPassword();
        resetPasswordPage.visibleResetPassword();
        resetPasswordPage.urlIsCorrect("forgot-password");

    }
    @Test @Description ("click on facebook link")
    public void facebookPageIsOpen (){
        loginPage.facebookIsDisplayed();
        loginPage.clickOnFacebookLink();
        facebookPage.facebookPageIsOpen();
}

    @Test @Description ("click on twitter link")
    public void twitterPageIsOpen (){
        loginPage.clickOnTwitterLink();
        loginPage.twitterIsDisplayed();
        twitterPage.twitterPageIsOpen();
    }

    @Test @Description ("click on instagram link")
    public void instagramPageIsOpen (){
        loginPage.clickOnInstagramLink();
        loginPage.instagramIsDisplayed();
        instagramPage.instagramPageIsOpen();
    }
}