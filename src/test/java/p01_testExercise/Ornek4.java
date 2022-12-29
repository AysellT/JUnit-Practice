package p01_testExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ornek4 {

    public static void main(String[] args) throws InterruptedException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");

        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        //driver.findElement(By.xpath("//div[@id='dismiss-button']")).click(); reklamlari kapat

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductYazisi = driver.findElement(By.xpath("//h2[text()='All Products']"));

        if (allProductYazisi.isDisplayed()){
            System.out.println("ALL PRODUCTS sayfasina basariyla yonlendirildi test PASSED");
        }else{
            System.out.println("ALL PRODUCTS sayfasina yonlendirilemedi test FAILED");
        }

        //5. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("jeans");
        driver.findElement(By.id("submit_search")).click();

        //6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchProductsYazisi = driver.findElement(By.xpath("//h2[text()='Searched Products']"));

        if (searchProductsYazisi.isDisplayed()){
            System.out.println("SEARCHED PRODUCTS gorunur, test PASSED");
        }else{
            System.out.println("SEARCHED PRODUCTS gorunmuyor, test FAILED");
        }

        //7. Verify all the products related to search are visible
        WebElement products = driver.findElement(By.xpath("//div[@class='features_items']"));
        if (products.isDisplayed()){
            System.out.println("aranan urunler gorunuyor, test PASSED");
        }else{
            System.out.println("aranan urunler gorunmuyor, test FAILED");
        }
        Thread.sleep(3000);
        //8. Add those products to cart
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        driver.findElement(By.xpath("(//a[text()='Add to cart'])[3]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        driver.findElement(By.xpath("(//a[text()='Add to cart'])[5]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        //9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        WebElement urun1 = driver.findElement(By.xpath("//a[text()='Soft Stretch Jeans']"));
        WebElement urun2 = driver.findElement(By.xpath("//a[text()='Regular Fit Straight Jeans']"));
        WebElement urun3 = driver.findElement(By.xpath("//a[text()='Grunt Blue Slim Fit Jeans']"));

        if (urun1.isDisplayed() && urun2.isDisplayed() && urun3.isDisplayed()){
            System.out.println("secili urunler sepete eklendi, test PASSED");
        }else{
            System.out.println("secili urunler sepete eklenmedi, test FAILED");
        }

        //10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("suleymancan157@hotmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Aysel.turg30");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //11. Again, go to Cart page
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();

        //12. Verify that those products are visible in cart after login as well
        WebElement urun = driver.findElement(By.xpath("//a[text()='Soft Stretch Jeans']"));
        WebElement urunn = driver.findElement(By.xpath("//a[text()='Regular Fit Straight Jeans']"));
        WebElement urunnn = driver.findElement(By.xpath("//a[text()='Grunt Blue Slim Fit Jeans']"));

        if (urun.isDisplayed() && urunn.isDisplayed() && urunnn.isDisplayed()){
            System.out.println("secili urunler sepete eklendi, test PASSED");
        }else{
            System.out.println("secili urunler sepete eklenmedi, test FAILED");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
