package p02_JUnit_Exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnit05 {

      /*
           1. Launch browser
           2. Navigate to url 'http://automationexercise.com'
           3. Verify that home page is visible successfully
           4. Add products to cart
           5. Click 'Cart' button
           6. Verify that cart page is displayed
           7. Click 'X' button corresponding to particular product
           8. Verify that product is removed from the cart
            */

    WebDriver driver ;

    @Before
    public void setUp(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test(){
        //3. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //4. Add products to cart
        WebElement eklenecekurun = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));
        eklenecekurun.click();
        //5. Click 'Cart' button
        driver.findElement(By.linkText("View Cart")).click();

        //6. Verify that cart page is displayed
        WebElement shoppingCartElementi = driver.findElement(By.xpath("//li[text()='Shopping Cart']"));
        Assert.assertTrue(shoppingCartElementi.isDisplayed());

        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();

        //8. Verify that product is removed from the cart
        WebElement urun = driver.findElement(By.xpath("//a[text()='Blue Top']"));
        Assert.assertTrue(urun.isDisplayed());

    }
}
