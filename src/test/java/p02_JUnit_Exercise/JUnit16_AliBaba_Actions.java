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

    public class JUnit16_AliBaba_Actions {

        //https://www.alibaba.com/?spm=a2700.7699653.0.0.7bc23e5f7N3QQV
        //shipto kismina giderek ulke olarak turkiye yi secelim ve kaydedelim
        //sayfanin en altina inerek dil olarak turkceyi secelim
        //categori kismina giderek tarim seceneginin ustune gelelim ve acilan yan sayfadan tarim ekipmanlarini secelim
        //tekrardan ilk sayfaya gecelim

        WebDriver driver ;

        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @After
        public void teardown(){
            driver.close();
        }

        @Test
        public void test01(){

            //https://www.alibaba.com/?spm=a2700.7699653.0.0.7bc23e5f7N3QQV
            driver.get("https://www.alibaba.com/");
            String ilkSayfaWHD = driver.getWindowHandle();

            //shipto kismina giderek ulke olarak turkiye yi secelim ve kaydedelim
            Actions aliBaba = new Actions(driver);
            WebElement shipTo = driver.findElement(By.xpath("(//label[@class='ellipsis'])[3]"));
            aliBaba.moveToElement(shipTo).perform();
            ReusableMethod.bekle(2);

            WebElement country = driver.findElement(By.xpath("//div[@data-role='select-country']"));
            ReusableMethod.bekle(2);
            aliBaba.click(country).perform();

            ReusableMethod.bekle(2);

            WebElement aramaKutusu = driver.findElement(By.xpath("//input[@placeholder='Enter keyword to search.']"));
            aliBaba.sendKeys(aramaKutusu,"Turkey").perform();

            driver.findElement(By.xpath("(//li[@data-value='TR'])[1]")).click();
            driver.findElement(By.xpath("(//button[@data-role='save'])[3]")).click();

            ReusableMethod.bekle(2);
            //sayfanin en altina inerek dil olarak turkceyi secelim
            aliBaba.sendKeys(Keys.END).perform();
            ReusableMethod.bekle(2);
            driver.findElement(By.xpath("//a[text()='Türk']")).click();


            //categori kismina giderek tarim seceneginin ustune gelelim ve acilan yan sayfadan tarim ekipmanlarini secelim
            WebElement kategori = driver.findElement(By.xpath("(//*[text()='Kategoriler'])[2]"));
            aliBaba.moveToElement(kategori).clickAndHold(kategori).perform();
            ReusableMethod.bekle(2);
            WebElement tarim = driver.findElement(By.xpath("(//a[text()='Tarım'])[3]"));
            aliBaba.moveToElement(tarim).clickAndHold(tarim).perform();
            ReusableMethod.bekle(2);
            WebElement tarimEkipmanlari = driver.findElement(By.xpath("(//a[text()='Tarım Ekipmanları'])[2]"));
            aliBaba.moveToElement(tarimEkipmanlari).click(tarimEkipmanlari).perform();
            ReusableMethod.bekle(2);

            //tekrardan ilk sayfaya gecelim
            driver.switchTo().window(ilkSayfaWHD);

        }

    }


