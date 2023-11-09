import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.Assert.assertTrue;

public class FacebookPage {

    private SelenideElement header = $ (byTagName("h1"));

    public void facebookPageIsOpen
            (){
        switchTo().window(1, Duration.ofSeconds(5));
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("facebook.com/mycompany"));
    }

}
