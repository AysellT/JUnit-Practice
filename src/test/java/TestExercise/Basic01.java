package TestExercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Basic01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com.tr");
        System.out.println(driver.getTitle()); //Amazon.com. Spend less. Smile more.

        String expectedKelime = "alisveris";
        String pageSource = driver.getPageSource();

        if (pageSource.contains(expectedKelime)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
