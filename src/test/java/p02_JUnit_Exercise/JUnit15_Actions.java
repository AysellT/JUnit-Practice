package p02_JUnit_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

public class JUnit15_Actions extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully

    @Test
    public void test01(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement automationExercise = driver.findElement(By.xpath("//div[@class='logo pull-left']"));

        //4. Click on 'Contact Us' button
        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()=' Contact us']"));
        contactUsLink.click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchYazi = driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        Assert.assertTrue(getInTouchYazi.isDisplayed());

        //6. Enter name, email, subject and message
        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='name']"));
        Faker faker = new Faker();
        Actions actions = new Actions(driver);

        actions.click(nameBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("Siparis teslim suresi")
                .sendKeys(Keys.TAB)
                .sendKeys("siparis teslim suresi sitede yazilan tarihten 3 gun gec geldi").perform();

        ReusableMethod.bekle(3);

        //7. Upload file
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@name='upload_file']"));
        String dosyaYolu = System.getProperty("user.home")+"Desktop/evrak/FATURA.txt";
        actions.click(chooseFileButton).sendKeys(dosyaYolu);

        //8. Click 'Submit' button
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
        ReusableMethod.bekle(3);

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successYazi = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(successYazi.isDisplayed());

        ReusableMethod.bekle(3);

        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement homeButton = driver.findElement(By.xpath("//span[text()=' Home']"));
        homeButton.click();

        String expectedKelime="automationexercise";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedKelime));

    }
}
