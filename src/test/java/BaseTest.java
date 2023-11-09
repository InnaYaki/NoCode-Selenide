import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;

import java.util.Random;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public final String BASE_URL =  "https://jere237.softr.app/sign-in";



    @Before

    public void setUp (){

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open (BASE_URL);
    }

    final static String BASE_URI = "https://studio-api.softr.io/v1/api";
    final static String API_KEY = "khIbAyJIU5CIuh1oDuBRx1s49";
    final static String DOMAIN = "jere237.softr.app";

    static RequestSpecification specification = new RequestSpecBuilder()
            .setUrlEncodingEnabled(false)
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", API_KEY)
            .addHeader("Softr-Domain",DOMAIN )
            .build();

    public Response deleteRequest(String endPoint, Integer responseCode) {

        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public static String getRandomEmail() {
        String SALTCHARS = "abcdefghijklmopqrstuwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }
        @After
    public void  tearDown (){ closeWebDriver();}

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

    FacebookPage facebookPage = new FacebookPage();
    TwitterPage twitterPage = new TwitterPage();
    InstagramPage instagramPage = new InstagramPage();

    RegistrationPage registrationPage = new RegistrationPage();



}
