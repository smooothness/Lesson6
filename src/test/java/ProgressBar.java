import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class ProgressBar {
    public static WebDriver driver;
    public static String url = "https://demoqa.com/progress-bar";
    Wait<WebDriver> wait;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    void progressBarIsFilled() {
        WebElement startButton = driver.findElement(By.cssSelector("button#startStopButton"));
        startButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//button[@id='resetButton']")));
    }

    @AfterEach
    void closeBrowser(){
        driver.quit();
    }
}