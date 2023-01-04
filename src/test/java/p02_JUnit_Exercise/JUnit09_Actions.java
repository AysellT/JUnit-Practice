package p02_JUnit_Exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class JUnit09_Actions extends TestBase {

    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2- Hover over Me First" kutusunun ustune gelin
    //3- Link 1" e tiklayin
    //4- Popup mesajini yazdirin
    //5- Popup'i tamam diyerek kapatin
    //6- “Click and hold" kutusuna basili tutun
    //7- “Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin

    @Test
    public void test01(){

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirstElementi = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirstElementi).perform();

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();

        //4- Popup mesajini yazdirin
        System.out.println("Popup mesaji : "+driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        actions.sendKeys(Keys.PAGE_DOWN);

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldelement = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldelement).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldelement.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleClick).perform();

    }
}
