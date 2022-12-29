package p01_testExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Ornek1 {

    public static void main(String[] args) throws InterruptedException {
        //1 - Bir test class'i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/adresine gidin
        driver.get("https://www.automationexercise.com");

        //3- Category bolumundeki elementleri locate edin
        List<WebElement> kategoriListesi = driver.findElements(By.className("panel-heading"));

        //4- Category bolumunde 3 element oldugunu test edin
        if (kategoriListesi.size()==3){
            System.out.println("test PASSED");
        }else{
            System.out.println("test FAILED");
        }

        //5- Category isimlerini yazdirin
        for (WebElement each :kategoriListesi){
            System.out.print(each.getText()+" ");
        }
        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
