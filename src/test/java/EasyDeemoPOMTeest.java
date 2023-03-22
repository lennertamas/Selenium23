import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class EasyDeemoPOMTeest {

    WebDriver driver;

    @BeforeEach
    public void init()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void simpleFormTest()
    {
        String expected = "Tomi";

        IndexPage indexPage = new IndexPage(driver);
        indexPage.navigate();
        SimpleFormPage simpleFormPage = indexPage.navigateToSimpleForm();

        //SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
        simpleFormPage.writeText(expected);
        simpleFormPage.clickButton();
        String actual = simpleFormPage.getMessage();

        Assertions.assertEquals(expected, actual);

    }
}
