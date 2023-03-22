import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {

    private WebDriver driver;

    private final String url = "https://demo.seleniumeasy.com/";
    private final By inputFormsMenuItem = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a");
    private final By simpleFormsMenuItem = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]/a");


    public IndexPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public void navigate()
    {
        driver.navigate().to(url);
    }

    public SimpleFormPage navigateToSimpleForm()
    {
        driver.findElement(inputFormsMenuItem).click();
        driver.findElement(simpleFormsMenuItem).click();

        return new SimpleFormPage(driver);
    }

    /*
    public void clickInputMenuItem()
    {
        driver.findElement(inputFormsMenuItem).click();
    }

    public void clickSimpleMenuItem()
    {
        driver.findElement(simpleFormsMenuItem).click();
    }
    */



}
