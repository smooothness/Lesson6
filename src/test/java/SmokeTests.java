import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SmokeTests {
    public static WebDriver driver;
    public static String url = "https://demoqa.com/";
    public static String falseUrl = "https://github.com/";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyHomeUrl(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url, "The Home URLs don't match");
    }

    @Test
    public void navigateToElementsPage() {
        WebElement elements = driver.findElement(By.cssSelector("div:nth-of-type(1) > div > .avatar.mx-auto.white"));
        elements.click();

        String currentUrl = driver.getCurrentUrl();
        String expectedURL = "https://demoqa.com/elements";
        Assert.assertEquals(currentUrl, expectedURL, "The Elements URLs don't match");
    }

    @Test
    public void navigateToFormsPage() {
        WebElement elements = driver.findElement(By.cssSelector("div:nth-of-type(2) > div > .avatar.mx-auto.white > svg"));
        elements.click();

        String currentUrl = driver.getCurrentUrl();
        String expectedURL = "https://demoqa.com/forms";
        Assert.assertEquals(currentUrl, expectedURL, "The Forms URLs don't match");
    }

    @AfterEach
    void closeBrowser(){
        driver.quit();
    }

}
