package p02_JUnit_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.util.Set;

public class JUnit10_Alert extends TestBase {

    // 1."http://webdriveruniversity.com/" adresine gidin
    // 2."Login Portal" a kadar asagi inin
    // 3."Login Portal" a tiklayin
    // 4.Diger window'a gecin
    // 5."username" ve "password" kutularina deger yazdirin
    // 6."login" butonuna basin
    // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    // 8.Ok diyerek Popup'i kapatin
    // 9.Ilk sayfaya geri donun
    // 10.Ilk sayfaya donuldugunu test edin

    @Test
    public void test01(){
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaWHD = driver.getWindowHandle();
        ReusableMethod.bekle(3);

        // 2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement loginLink = driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']"));
        //actions.scrollToElement(loginLink).perform();

        // 3."Login Portal" a tiklayin
        loginLink.click();

        // 4.Diger window'a gecin
        Set<String> tumWHD = driver.getWindowHandles();
        String ikinciSayfaWHD = "";
        for (String eachWHD:tumWHD){
            if (!ilkSayfaWHD.equals(eachWHD)){
                ikinciSayfaWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);

        // 5."username" ve "password" kutularina deger yazdirin
        WebElement userName = driver.findElement(By.id("text"));
        Faker faker = new Faker();
        actions.click(userName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).perform();

        ReusableMethod.bekle(3);

        // 6."login" butonuna basin
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "validation failed";
        Assert.assertEquals(expectedText,actualText);

        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        // 9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaWHD);

        // 10.Ilk sayfaya donuldugunu test edin
        String expectedTitle = "WebDriverUniversity";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

    }
}
