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

public class JUnit01 {

    //1- C01_TekrarTesti isimli bir class olusturun
    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6- Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8- Sayfayi kapatin

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        //8- Sayfayi kapatin
        driver.close();
    }

    @Test
    public void test(){
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Nutella"+ Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucElement = driver.findElement(By.id("result-stats"));
        System.out.println(sonucElement.getText());//Yaklaşık 146.000.000 sonuç bulundu (0,38 saniye)

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        int expectedSonuc = 10000000;

        String sonucSayisiText = sonucElement.getText();//Yaklaşık 146.000.000 sonuç bulundu (0,38 saniye)

        String [] sonucSayisiArr = sonucSayisiText.split(" ");//[Yaklaşık , 146.000.000 , sonuç , ....]

        String actualSonucSayisStr = sonucSayisiArr[1]; //146.000.000 int'a donusturmek icin "." dan kurtulmaliyim

        String actualSonucSayisi = actualSonucSayisStr.replaceAll("\\D","");//146000000

        int actualSonucInt = Integer.parseInt(actualSonucSayisi);

        Assert.assertTrue(actualSonucInt>expectedSonuc);

    }
}
