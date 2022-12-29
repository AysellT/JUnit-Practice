package p01_testExercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigateMethod {


    public static void main(String[] args) throws InterruptedException {

        // 1.Yeni bir class olusturalim (Homework)
        // 2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");

        String expectedKelime = "Facebook";
        String actualResult = driver.getTitle();
        if (actualResult.contains(expectedKelime)){
            System.out.println("Title dogrulandi, title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
            System.out.println(driver.getTitle());
        }

        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String expectedKelime2 = "facebook";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedKelime2)){
            System.out.println("URL testi PASSED");
        }else{
            System.out.println("URL testi FAILED");
            System.out.println(driver.getCurrentUrl());
        }

        // 4.https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");

        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedKelime3 = "Walmart.com";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedKelime3)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        // 6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        // 7. Sayfayi yenileyin
        driver.navigate().refresh();
        // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // 9.Browser’i kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
