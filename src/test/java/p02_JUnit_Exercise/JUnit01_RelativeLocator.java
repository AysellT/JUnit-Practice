package p02_JUnit_Exercise;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class JUnit01_RelativeLocator extends TestBase {

    // http://www.bestbuy.com 'a gidin
    // sayfa basliginin "Best" icerdigini dogrulayin
    // Relative Locator kulanarak;
    //     logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
    // Relative Locator kulanarak;
    //     mexicoLinkTest => Link'in goruntulenip goruntulenmedigini dogurlayin

    @Before
    public void beforeTest(){
        driver.get("http://www.bestbuy.com"); //her test'ten once calismasini istiyorum
    }

    @Test
    public void titleTest(){
        // sayfa basliginin "Best" icerdigini dogrulayin
        String expectedKelime = "Best";
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains(expectedKelime));
    }

    @Test
    public void logoTest() {
        // Relative Locator kulanarak;
        //     logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement helloElement = driver.findElement(By.xpath("//div[text()='Hello!']"));
        WebElement bestBuyLogo = driver.findElement(RelativeLocator.with(By.tagName("div")).above(helloElement));
        assertTrue(bestBuyLogo.isDisplayed());

    }

    @Test
    public void mexicoLinkTest(){
        // Relative Locator kulanarak;
        // mexicoLinkTest => Link'in goruntulenip goruntulenmedigini dogurlayin

        WebElement usFlag = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoFlag = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usFlag));
        assertTrue(mexicoFlag.isDisplayed());

    }
}
