package p02_JUnit_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class JUnit08_IFrame extends TestBase {

    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
    //6) (https://www.guru99.com/live-selenium-project.html) sayfasına gittiğinizi test edin

    @Test
    public void test01(){

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");


        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> tumIframe = driver.findElements(By.tagName("iframe"));
        System.out.println(tumIframe.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement yotubeIframe = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(yotubeIframe);

        WebElement youtubeButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        youtubeButton.click();

        ReusableMethod.bekle(3);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

    }

    @Test
    public void test02(){

        String ilkSayfaWHD = driver.getWindowHandle();

        //5) ikinci iframe'deki (Jmeter Made Easy)  tıklayınız
        WebElement jMadeIframe = driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(jMadeIframe);

        WebElement jMadeEasy = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
        jMadeEasy.click();

        String ikinciSayfaWHD = "";
        Set<String> tumWHD = driver.getWindowHandles();
        for (String eachWHD : tumWHD){
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);

        //6) (https://www.guru99.com/live-selenium-project.html) sayfasına gittiğinizi test edin
        String expectedKelime = "selenium";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedKelime));

    }


}
