package p01_testExercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigateMethodExercise {

    public static void main(String[] args) throws InterruptedException {
        //1. Yeni bir class olusturun (TekrarTesti)
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

        String expectedResult = "youtube";
        String actualResult = driver.getTitle();

        if (actualResult.equalsIgnoreCase(expectedResult)) {
            System.out.println(" youtube Title testi PASSED");
        } else {
            System.out.println("youtube Title testi FAILED");
            System.out.println(actualResult);
        }

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        //doğru URL'yi yazdırın.
        String expectedKelime2 = "youtube";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains(expectedKelime2)) {
            System.out.println("Youtube URL testi PASSED");
        } else {
            System.out.println("Youtube URL testi FAILED");
            System.out.println(actualURL);
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");
        //5. Youtube sayfasina geri donun
        driver.navigate().back();
        // 6. Sayfayi yenileyin
        driver.navigate().refresh();
        //7. Amazon sayfasina donun
        driver.navigate().forward();
        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Amazon title testi PASSED");
        } else {
            System.out.println("Amazon title testi FAILED");
            System.out.println(actualTitle);
        }

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String expectedAmazonUrl = "https://www.amazon.com/";
        String actualAmazonUrl = driver.getCurrentUrl();
        if (actualAmazonUrl.equals(expectedAmazonUrl)) {
            System.out.println("Amazon url Testi PASSED");
        } else {
            System.out.println("Amazon url testi FAILED");
            System.out.println(actualAmazonUrl);
        }

        //11.Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();


    }
}