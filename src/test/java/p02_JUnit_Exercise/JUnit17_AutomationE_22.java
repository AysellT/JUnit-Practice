package p02_JUnit_Exercise;

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

import java.time.Duration;

public class JUnit17_AutomationE_22 {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Scroll to bottom of page
        //4. Verify 'RECOMMENDED ITEMS' are visible
        //5. Click on 'Add To Cart' on Recommended product
        //6. Click on 'View Cart' button
        //7. Verify that product is displayed in cart page
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
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }

        @Test
        public void test() throws InterruptedException {
            //3. Scroll to bottom of page
            WebElement homeYazi = driver.findElement(By.xpath("//a[text()=' Home']"));
            homeYazi.sendKeys(Keys.END);
            homeYazi.sendKeys(Keys.PAGE_UP);
            Thread.sleep(3000);

            //4. Verify 'RECOMMENDED ITEMS' are visible
            WebElement recommendedYazi = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
            Assert.assertTrue(recommendedYazi.isDisplayed());

            //5. Click on 'Add To Cart' on Recommended product
            driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();

            //6. Click on 'View Cart' button
            driver.findElement(By.linkText("View Cart")).click();

            //7. Verify that product is displayed in cart page
            WebElement urun = driver.findElement(By.linkText("Blue Top"));
            Assert.assertTrue(urun.isDisplayed());


        }
}


