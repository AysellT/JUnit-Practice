package p02_JUnit_Exercise;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class JUnit06_RegisterUser {


    //Automation Exercise TestCase01
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    WebDriver driver ;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignupElementi = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignupElementi.isDisplayed());

        //6. Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        actions.click(name)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).perform();

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountElementi = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountElementi.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement genderTitle = driver.findElement(By.id("uniform-id_gender2"));
        actions.click(genderTitle)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("25")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN).perform();

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameKutusu = driver.findElement(By.id("first_name"));
        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("New Zealand")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(faker.address().state())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().cityName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).perform();

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated =driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        //16. Verify that 'Logged in as username' is visible
        WebElement loggedInElementi = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedInElementi.isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeleted.isDisplayed());

    }
}
