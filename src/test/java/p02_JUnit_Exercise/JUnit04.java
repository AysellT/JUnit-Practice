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
import java.util.List;

public class JUnit04 {


    /*
       Test Case 19: View & Cart Brand Products
         1. Launch browser
         2. Navigate to url 'http://automationexercise.com'
         3. Click on 'Products' button
         4. Verify that Brands are visible on left side bar
         5. Click on any brand name
         6. Verify that user is navigated to brand page and brand products are displayed
         7. On left side bar, click on any other brand link
         8. Verify that user is navigated to that brand page and can see products
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
    public void test01() throws InterruptedException {
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        //4. Verify that Brands are visible on left side bar
        List<WebElement> brandsListesi = driver.findElements(By.xpath("//span[@class='pull-right']"));

        for (WebElement eachBrands:brandsListesi){
            Assert.assertTrue(eachBrands.isDisplayed());
        }

        Thread.sleep(5000);

        //5. Click on any brand name
        WebElement babyHug = driver.findElement(By.xpath("//a[text()='Babyhug']"));
        babyHug.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(5000);
        babyHug.click();
        Thread.sleep(5000);
        //6. Verify that user is navigated to brand page and brand products are displayed
        WebElement babyHugYazi = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(babyHugYazi.isDisplayed());

        //7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[text()='Polo']")).click();
        Thread.sleep(5000);

        //8. Verify that user is navigated to that brand page and can see products
        WebElement ikinciMarkaYazisi = driver.findElement(By.xpath("//h2[text()='Brand - Polo Products']"));
        Assert.assertTrue(ikinciMarkaYazisi.isDisplayed());

    }
}
