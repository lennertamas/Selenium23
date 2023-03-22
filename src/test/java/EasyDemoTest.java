import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class EasyDemoTest {

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
    public void testInput() throws InterruptedException {
        String expected = "Tomi";

        driver.navigate().to("https://demo.seleniumeasy.com/");
        WebElement menu1 = driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a"));
        menu1.click();
        WebElement menu2 = driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]/a"));
        menu2.click();


        WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"user-message\"]"));
        inputBox.sendKeys(expected);

        Thread.sleep(1000);

        //driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"get-input\"]/button")));
        element.click();

        Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = fluent.until(driver -> {
            return driver.findElement(By.id("foo"));
        });


        String actualResult = driver.findElement(By.xpath("//*[@id=\"display\"]")).getText();

        Assertions.assertEquals(expected, actualResult);
        //driver.close();


        //driver.manage().window().maximize();
        //driver.close();
        //driver.get("https://demo.seleniumeasy.com/");
    }

    @Test
    public void testHeaders()
    {
        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
        List<WebElement> elements = driver.findElements(By.xpath("//h4"));
        String actual = "";
        for (WebElement element : elements)
        {
            actual += element.getText();
        }

        String expectd = "Tomi, Tomi";
        Assertions.assertEquals(expectd, actual);

    }

    @Test
    public  void testRelativePath()
    {
        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
        List<WebElement>  rows = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/table/tbody/tr"));
        for (WebElement row : rows)
        {
            List<WebElement> cells = row.findElements(By.xpath("./td"));
            for (WebElement cell : cells)
            {
                String string = cell.getText();
            }
        }
    }



    @Test
    public  void testRelativePath2()
    {
        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
        List<WebElement>  rows = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/table/tbody/tr"));

        Integer counter = 1;
        for (WebElement row : rows)
        {
            WebElement cell= row.findElement(By.xpath("./td[1]"));
            System.out.println(cell.getText());
            Assertions.assertEquals(counter.toString(), cell.getText());
            counter++;
        }
        By.xpath("//*[@id=\"treemenu\"]");
        By.id("treemenu");

        //*[@id="treemenu"]
        //*[@class="container-fluid text-center"]
        //*[contains(@class, "container-fluid")]
        //*[contains(@class, "container-fluid") or contains(@class, "navbar")]
        //*[contains(text(),"Menu")]

    }

}
