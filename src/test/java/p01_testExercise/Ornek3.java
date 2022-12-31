package p01_testExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ornek3 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'View Product' for any product on home page
    //5. Verify product detail is opened
    //6. Increase quantity to 4
    //7. Click 'Add to cart' button
    //8. Click 'View Cart' button
    //9. Verify that product is displayed in cart page with exact quantity

    public static void main(String[] args) throws InterruptedException {

        //1. Launch browser
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Sayfa goruntulendi , test PASSED");
        } else {
            System.out.println("Sayfa goruntulenemedi , test FAILED");
        }

        //4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("(//a[@style='color: brown;'])[2]")).click();

        //5. Verify product detail is opened
        WebElement details = driver.findElement(By.xpath("//div[@class='product-information']"));
        if (details.isDisplayed()) {
            System.out.println("Detaylar gorunuyor, test PASSED");
        } else {
            System.out.println("Detaylar gorunmuyor , test FAILED");
        }

        //6. Increase quantity to 4
        WebElement urunSayisiElementi = driver.findElement(By.xpath("//input[@id='quantity']"));
        urunSayisiElementi.clear();
        urunSayisiElementi.sendKeys("4");

        Thread.sleep(3000);

        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.linkText("View Cart")).click();

        //9. Verify that product is displayed in cart page with exact quantity
        WebElement siparisAdedi = driver.findElement(By.xpath("//button[@class='disabled']"));
        int actualSiparisAdedi = Integer.parseInt(siparisAdedi.getText());

        if (actualSiparisAdedi==4) {
            System.out.println("Adet dogru verilmis, test PASSED");
        } else {
            System.out.println("Adet yanlis verilmis, test FAILED");
        }

        Thread.sleep(3000);
        driver.close();

    }

}
