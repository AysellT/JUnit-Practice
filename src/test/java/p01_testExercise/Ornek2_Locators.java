package p01_testExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ornek2_Locators{

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com");

        // 2- Arama kutusuna “city bike” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

        // 3- Görüntülenen sonuçların sayısını yazdırın
        WebElement bikeSayisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String sonucText = bikeSayisi.getText();

        String [] sonucTextArr = sonucText.split(" ");

        String sonucSayisi = sonucTextArr[2]; //"121"

        int sonucSayisiInt = Integer.parseInt(sonucSayisi);//121

        System.out.println(sonucSayisiInt+" adet sonuc bulundu");


        // 4- Listeden ilk urunun resmine tıklayın.
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();


        Thread.sleep(3000);
        driver.close();
    }
}
