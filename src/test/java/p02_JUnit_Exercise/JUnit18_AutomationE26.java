package p02_JUnit_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class JUnit18_AutomationE26 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down page to bottom
    //5. Verify 'SUBSCRIPTION' is visible
    //6. Scroll up page to top
    //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

    @Test
    public void test01(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement automationLogo = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(automationLogo.isDisplayed());

        //4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);

        //5. Verify 'SUBSCRIPTION' is visible
        WebElement subscriptionElement = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(subscriptionElement.isDisplayed());

        //6. Scroll up page to top
        actions.sendKeys(Keys.ARROW_UP);

        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

    }

}
