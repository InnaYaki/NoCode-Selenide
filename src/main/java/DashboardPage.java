import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement header= $ (byXpath("//img[@class='sw-width-5xs']"));

    public void dashboardPageIsOpen(){
        header.shouldBe(visible, Duration.ofSeconds(10));
    }

    private SelenideElement buttonAddCourse = $ (By.cssSelector
            ("[href='/add-course']"));
    public void addCourseButtonIsDisplayed  () {
        buttonAddCourse.shouldBe(visible, Duration.ofSeconds(10));
    }



}
