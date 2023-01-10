package p02_JUnit_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

public class JUnit14_Actions extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible

    @Test
    public void test01(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anaSayfaLogo = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(anaSayfaLogo.isDisplayed());

        //4. Scroll down to footer
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        ReusableMethod.bekle(3);

        //5. Verify text 'SUBSCRIPTION'
        WebElement subscriptionYazi = driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscriptionYazi.isDisplayed());

        //6. Enter email address in input and click arrow button
        WebElement emailbox = driver.findElement(By.id("susbscribe_email"));
        emailbox.sendKeys("flowers@gmail.com");

        WebElement okButton = driver.findElement(By.id("subscribe"));
        okButton.click();

        ReusableMethod.bekle(1);

        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement successYazi = driver.findElement(By.id("success-subscribe"));
        Assert.assertTrue(successYazi.isDisplayed());

    }

}
