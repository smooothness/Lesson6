import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.*;

public class AutoComplete {

    public static WebDriver driver;
    public static String url = "https://demoqa.com/auto-complete";
    Wait<WebDriver> wait;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    void populateAndVerifyTwoColors() {
        WebElement multipleColorTextBox = driver.findElement(By.cssSelector("#autoCompleteMultipleInput"));

        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Purple");
        colors.add("Indigo");

        Random r = new Random();

        int randomItemA = r.nextInt(colors.size());
        String a = colors.get(randomItemA);
        colors.remove(a);

        int randomItemB = r.nextInt(colors.size());
        String b = colors.get(randomItemB);

        multipleColorTextBox.click();

        multipleColorTextBox.sendKeys(a);
        multipleColorTextBox.sendKeys(Keys.ENTER);
        multipleColorTextBox.sendKeys(b);
        multipleColorTextBox.sendKeys(Keys.ENTER);

        WebElement valueA = driver.findElement(By.xpath("//div[@class='css-1rhbuit-multiValue auto-complete__multi-value'][1]"));
        WebElement valueB = driver.findElement(By.xpath("//div[@class='css-1rhbuit-multiValue auto-complete__multi-value'][2]"));

        String firstColor = valueA.getText();
        String secondColor = valueB.getText();

        Assertions.assertEquals(a, firstColor, "Colors do not match");
        Assertions.assertEquals(b, secondColor, "Colors do not match");
    }

    @AfterEach
    void closeBrowser(){
        driver.quit();
    }

}