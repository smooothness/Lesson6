import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.awt.event.MouseEvent;
import java.time.Duration;

public class StudentRegistrationForm {

    public static WebDriver driver;
    public static String url = "https://demoqa.com/automation-practice-form#google_vignette";
    Wait<WebDriver> wait;
    JavascriptExecutor executor;
    Logger logger;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        executor = (JavascriptExecutor)driver;
        logger = LogManager.getLogger(StudentRegistrationForm.class);
    }

    @Test
    public void fillRegistrationForm() {
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement genderRadioButtonMale = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        WebElement mobileField = driver.findElement(By.xpath("//input[@id='userNumber']"));

        WebElement dateOfBirthCalendarField = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));

        WebElement subjectField = driver.findElement(By.xpath("//div[@id='subjectsContainer']//input[@type='text']"));
        WebElement hobbiesCheckboxReading = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']"));
        WebElement pictureUploadButton = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        WebElement currentAddressTextBox = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        WebElement stateDropDown = driver.findElement(By.xpath("//div[@id='stateCity-wrapper']"));
        WebElement cityDropDown = driver.findElement(By.xpath("//div[@id='city']"));

        String firstName = "Bob";
        executor.executeScript("arguments[0].scrollIntoView(true);", firstNameField);
        firstNameField.sendKeys(firstName);
        logger.info("First name field was populated");
        //Assert.assertEquals(firstNameField.getAttribute("innerText"), firstName, "First name field does not contain the expected value");

        String lastName = "Johnson";
        executor.executeScript("arguments[0].scrollIntoView(true);", lastNameField);
        lastNameField.sendKeys(lastName);
        logger.info("Last name field was populated");
        //Assert.assertEquals(lastNameField.getAttribute("innerText"), lastName, "Last name field does not contain the expected value");

        String userEmail = "some@mail.com";
        executor.executeScript("arguments[0].scrollIntoView(true);", userEmailField);
        userEmailField.sendKeys(userEmail);
        logger.info("User e-mail field was populated");
        //Assert.assertEquals(userEmailField.getAttribute("innerText"), userEmail, "User Email field does not contain the expected value");

        //executor.executeScript("arguments[0].scrollIntoView(true);", genderRadioButtonMale);
        //genderRadioButtonMale.click();

        executor.executeScript("arguments[0].scrollIntoView(true);", dateOfBirthCalendarField);
        dateOfBirthCalendarField.click();

        WebElement calendarYearDropdown = driver.findElement(By.xpath("//div[@class='react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select']"));
        calendarYearDropdown.click();
        WebElement year2014 = driver.findElement(By.xpath("//option[@value='2014']"));
        year2014.click();

        WebElement calendarMonthDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        calendarMonthDropdown.click();
        WebElement monthJune = driver.findElement(By.xpath("//option[@value='5']"));
        monthJune.click();

        WebElement selectDate = driver.findElement(By.xpath("//div[@aria-label='Choose Saturday, June 7th, 2014']"));
        selectDate.click();
        logger.info("Date of birth was selected");
        //Assert.assertEquals(dateOfBirthCalendarField.getAttribute("innerText"), "07 Jun 2014", "Date of birth field does not contain the expected value");

        String mobile = "1234567890";
        executor.executeScript("arguments[0].scrollIntoView(true);", mobileField);
        mobileField.sendKeys(mobile);
        logger.info("Mobile number field was populated");

        String subject1 = "English";
        String subject2 = "Computer Science";
        String subject3 = "Maths";
        executor.executeScript("arguments[0].scrollIntoView(true);", subjectField);
        subjectField.click();
        subjectField.sendKeys(subject1);
        subjectField.sendKeys(Keys.ENTER);
        logger.info("First subject option was populated");
        subjectField.sendKeys(subject2);
        subjectField.sendKeys(Keys.ENTER);
        logger.info("Second subject option was populated");
        subjectField.sendKeys(subject3);
        subjectField.sendKeys(Keys.ENTER);
        logger.info("Third subject option was populated");

        //actions.scrollToElement(hobbiesCheckboxReading);
        //hobbiesCheckboxReading.click();

        //pictureUploadButton.sendKeys("C:\\Users\\NikolaMikov\\OneDrive - Solveva\\Desktop.jpg");

        String currentAddress = "New York";
        executor.executeScript("arguments[0].scrollIntoView(true);", currentAddressTextBox);
        currentAddressTextBox.sendKeys(currentAddress);
        logger.info("Current address was populated");

        executor.executeScript("arguments[0].scrollIntoView(true);", stateDropDown);
        stateDropDown.click();
        WebElement stateOption1 = driver.findElement(By.xpath("//div[@id='react-select-3-option-1']"));
        stateOption1.click();
        logger.info("State option was selected");

        cityDropDown.click();
        WebElement cityOption2 = driver.findElement(By.xpath("//div[@id='react-select-4-option-2']"));
        cityOption2.click();
        logger.info("City option was selected");
    }

    //@AfterEach
    //void closeBrowser(){
    //    driver.quit();
    //}

}
