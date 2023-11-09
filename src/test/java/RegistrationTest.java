import jdk.jfr.Description;
import org.junit.Test;

public class RegistrationTest extends BaseTest {

    @Test
    @Description("success Registration with valid data as a teacher")

    public void SuccessRegistration() {
        String email = getRandomEmail();
         loginPage.clickOnSignUpButton();
         registrationPage.clickOnDropDown();
         registrationPage.enterRoleTeacher();
         registrationPage.enterFullName("Johny");
         registrationPage.enterEmailReg(email);
         registrationPage.enterPasswordFieldReg("123456");
         registrationPage.clickOnCheckBox();
         registrationPage.clickOnSignUpButton();
         dashboardPage.addCourseButtonIsDisplayed();
         deleteRequest("/users/"+ email,200);


    }

    @Test
    @Description("invalid data")
    public void invalidData() {
        loginPage.clickOnSignUpButton();
        registrationPage.clickOnDropDown();
        registrationPage.enterRoleTeacher();
        registrationPage.enterFullName("0000");
        registrationPage.enterEmailReg("-----");
        registrationPage.enterPasswordFieldReg("0000000");
        registrationPage.clickOnCheckBox();
        registrationPage.clickOnSignUpButton();
        registrationPage.checkTextErrorMessage(
                "Please make sure there are no empty required fields.");
    }


    @Test
    @Description("empty fields")
    public void emptyFields() {
        loginPage.clickOnSignUpButton();
        registrationPage.clickOnDropDown();
        registrationPage.enterRoleTeacher();
        registrationPage.enterFullName("");
        registrationPage.enterEmailReg("");
        registrationPage.enterPasswordFieldReg("");
        registrationPage.clickOnCheckBox();
        registrationPage.clickOnSignUpButton();
        registrationPage.checkTextErrorMessage(
                "Please make sure there are no empty required fields.");
    }




}
