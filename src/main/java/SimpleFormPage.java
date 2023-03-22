import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleFormPage {

    WebDriver driver;

    private final By inputBox = By.xpath("//*[@id=\"user-message\"]");
    private final By button = By.xpath("//*[@id=\"get-input\"]/button");
    private final By label = By.id("display");

    public SimpleFormPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void writeText(String testData)
    {
        driver.findElement(inputBox).sendKeys(testData);
    }

    public void clickButton()
    {
        driver.findElement(button).click();
    }

    public String getMessage()
    {
        String message = driver.findElement(label).getText();

        return message;
    }
}
