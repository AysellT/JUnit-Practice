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

import java.nio.file.Files;
import java.nio.file.Paths;

public class JUnit11_Actions_File extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Add products to cart
    //5. Click 'Cart' button
    //6. Verify that cart page is displayed
    //7. Click Proceed To Checkout
    //8. Click 'Register / Login' button
    //9. Fill all details in Signup and create account
    //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    //11. Verify ' Logged in as username' at top
    //12.Click 'Cart' button
    //13. Click 'Proceed To Checkout' button
    //14. Verify Address Details and Review Your Order
    //15. Enter description in comment text area and click 'Place Order'
    //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    //17. Click 'Pay and Confirm Order' button
    //18. Verify success message 'Your order has been placed successfully!'
    //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
    //20. Click 'Continue' button
    //21. Click 'Delete Account' button
    //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    @Test
    public void test01(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expected = "Automation Exercise";
        String actucalTitle = driver.getTitle();
        Assert.assertTrue(actucalTitle.contains(expected));

        //4. Add products to cart
        WebElement ikinciUrun = driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[5]"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethod.bekle(3);
        driver.findElement(By.xpath("(//a[@data-product-id='5'])[1]")).click();

        //5. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //6. Verify that cart page is displayed
        WebElement shoppingCartYazi = driver.findElement(By.xpath("//*[text()='Shopping Cart']"));
        Assert.assertTrue(shoppingCartYazi.isDisplayed());

        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();

        //9. Fill all details in Signup and create account
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        Faker faker = new Faker();
        actions.click(name)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).perform();

        driver.findElement(By.xpath("//button[text()='Signup']")).click();

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

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

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
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreated =driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        //11. Verify ' Logged in as username' at top
        WebElement loggedInElementi = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedInElementi.isDisplayed());

        //12.Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        //14. Verify Address Details and Review Your Order
        WebElement addressDetails = driver.findElement(By.xpath("//h2[text()='Address Details']"));
        Assert.assertTrue(addressDetails.isDisplayed());

        //15. Enter description in comment text area and click 'Place Order'
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("No Comment");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOnCart = driver.findElement(By.xpath("//input[@name='name_on_card']"));
        actions.click(nameOnCart)
                .sendKeys(faker.business().creditCardType())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.business().creditCardNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.business().creditCardExpiry())
                .sendKeys(Keys.TAB)
                .sendKeys("Jun")
                .sendKeys(Keys.TAB)
                .sendKeys("2025").perform();

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']")).click();

        //18. Verify success message 'Your order has been placed successfully!'
        WebElement siparisVerildiYazi = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(siparisVerildiYazi.isDisplayed());

        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        WebElement fatura = driver.findElement(By.xpath("//*[text()='Download Invoice']"));
        fatura.click();

        String dosyaYolu = System.getProperty("user.home")+"/Downloads/invoice.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //20. Click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        //21. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeleted.isDisplayed());

        driver.findElement(By.xpath("//a[text()='Continue']")).click();

    }

}
