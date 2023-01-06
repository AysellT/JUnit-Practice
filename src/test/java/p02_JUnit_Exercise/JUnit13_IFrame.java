package p02_JUnit_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase;

public class JUnit13_IFrame extends TestBase {

    @Test
    public void test01() {
        // 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // 2. “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.id("frame"));
        driver.switchTo().frame(iframe);
        WebElement ourProducts = driver.findElement(By.linkText("Our Products"));
        ourProducts.click();

        // 3. “Cameras product”i tiklayin
        WebElement camerasProduct = driver.findElement(By.xpath("//*[text()='Cameras']"));
        camerasProduct.click();

        ReusableMethod.bekle(3);

        // 4. Popup mesajini yazdirin
        WebElement popupMesaji = driver.findElement(By.xpath("//div[@class='modal-body']"));
        System.out.println(popupMesaji.getText());
        ReusableMethod.bekle(3);

        // 5. “close” butonuna basin
        WebElement closeButonu = driver.findElement(By.xpath("//button[text()='Close']"));
        closeButonu.click();

        ReusableMethod.bekle(3);

        // 6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        WebElement webdriverUniversity = driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']"));
        webdriverUniversity.click();

        ReusableMethod.bekle(3);

        // 7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "webdriveruniversity";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }

}
