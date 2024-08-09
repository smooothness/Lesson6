import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    public static WebDriver driver;
    public static String url = "https://practicetestautomation.com/practice-test-exceptions/";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void testMethod() {
        WebElement field = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println(field.getDomAttribute("value"));
    }

    @AfterEach
    void closeBrowser(){
        driver.quit();
    }

}
