package p02_JUnit_Exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnit03_Youtube {


    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //       ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //       ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //       ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //       ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void Titletest() {
        //       ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void imageTest() {
        //       ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youTubeResimElementi = driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(youTubeResimElementi.isDisplayed());
    }

    @Test
    public void searchBox() {
        //       ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled()) test edin
        WebElement searchBoxElementi = driver.findElement(By.id("search-input"));
        Assert.assertTrue(searchBoxElementi.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        //       ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
}
