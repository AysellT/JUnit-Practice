package p02_JUnit_Exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;

import java.time.Duration;

public class JUnit02_Teknosa {


    // 1- https://www.teknosa.com/ adresine gidin
    // 2- Arama cubuguna "oppo" yazin
    // 3- Cikan sonuc sayisini yazdirin
    // 4- Cikan ilk urune tiklayin
    // 5- Sepete ekleyiniz
    // 6- Sepetime git'e tiklayin
    // 7- consol da "Siparis Ozeti" webelementinin text'ini yazdirin
    // 8- Alisverisi tamamlayin'a tikla
    // 9- Son olarak "Teknosa'ya hos geldiniz" webelementinin text'ini yazdirin

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        // 1- https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        // 2- Arama cubuguna "oppo" yazin
        driver.findElement(By.id("search-input")).sendKeys("Oppo"+ Keys.ENTER);

        // 3- Cikan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.className("plp-info"));
        System.out.println(sonucSayisi.getText()+" bulundu");

        // 4- Cikan ilk urune tiklayin
        ReusableMethod.bekle(3);
        Actions actions = new Actions(driver);
        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='prd-body'])[1]"));
        actions.click(ilkUrun).perform();
        ReusableMethod.bekle(3);

        // 5- Sepete ekleyiniz
        WebElement sepetEkleButonu = driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]"));
        sepetEkleButonu.click();

        // 6- Sepetime git'e tiklayin
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

        // 7- consol da "Siparis Ozeti" webelementinin text'ini yazdirin
        WebElement siparisOzeti = driver.findElement(By.xpath("//div[@class='cart-sum-body']"));
        System.out.println(siparisOzeti.getText());

        // 8- Alisverisi tamamlayin'a tikla
        driver.findElement(By.xpath("//*[text()='Alışverişi Tamamla']")).click();

        // 9- Son olarak "Teknosa'ya hos geldiniz" webelementinin text'ini yazdirin
        WebElement sonText = driver.findElement(By.xpath("//div[text()='Teknosa’ya Hoş Geldiniz']"));
        System.out.println(sonText.getText());

    }

}
