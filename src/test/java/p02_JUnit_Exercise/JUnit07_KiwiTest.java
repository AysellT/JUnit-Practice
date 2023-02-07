package p02_JUnit_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethod;
import utilities.TestBase;

public class JUnit07_KiwiTest extends TestBase {
    String https = "https://www.";

    @Test
    public void kiwiTest() {
        // https://www.kiwi.com sayfasina gidin
        driver.get(https + "kiwi.com");

        // Cookies'i reddedin
        WebElement cookies = driver.findElement(By.xpath("//div[text()='Reject all']"));
        cookies.click();

        // Sayfa basliginin "Kiwi" icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Kiwi"));

        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        WebElement dilSecimi = driver.findElement(By.xpath("//*[text()='TRY']"));
        dilSecimi.click();
        WebElement selectWebElement = driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
        Select select = new Select(selectWebElement);
        select.selectByValue("tr");

        WebElement currencySelect=driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
        Select select1 = new Select(currencySelect);
        select1.selectByVisibleText("Turkish lira - TRY");

        WebElement saveButton = driver.findElement(By.xpath("//button[@data-test='SubmitRegionalSettingsButton']"));
        saveButton.click();

        // Sectiginiz dil ve para birimini dogrulayin
        WebElement text = driver.findElement(By.xpath("//*[text()='TRY']"));
        Assert.assertTrue(text.getText().contains("TRY"));

        // Ucus secenegi olarak tek yon secelim
        WebElement yonSecimi = driver.findElement(By.xpath("(//button[@type='button'])[12]"));
        yonSecimi.click();

        WebElement tekYonSecimi = driver.findElement(By.xpath("//a[@data-test='ModePopupOption-oneWay']"));
        tekYonSecimi.click();

        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
        WebElement deletedefaultcity = driver.findElement(By.xpath("//div[@data-test='PlacePickerInputPlace-close']"));
        deletedefaultcity.click();

        WebElement kalkisTextBox = driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
        kalkisTextBox.sendKeys("Istanbul");
        WebElement istanbulTurkiye = driver.findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]"));
        istanbulTurkiye.click();

        WebElement varisNoktasiBox = driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
        varisNoktasiBox.click();
        varisNoktasiBox.sendKeys("Prag");
        driver.findElement(By.xpath("//*[text()='Prag, Çekya']")).click();

        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        WebElement gidisTarih = driver.findElement(By.xpath("//input[@data-test='SearchFieldDateInput']"));
        gidisTarih.click();
        ReusableMethod.bekle(3);
        driver.findElement(By.xpath("(//div[@data-test='DayContentContainer'])[58]")).click();
        driver.findElement(By.xpath("//button[@data-test='SearchFormDoneButton']")).click();
        ReusableMethod.bekle(2);
        driver.findElement(By.xpath("//*[text()='Booking.com ile konaklama arayın']")).click();//booking'i iptaledelim
        ReusableMethod.bekle(3);
        driver.findElement(By.xpath("//a[@data-test='LandingSearchButton']")).click();


        // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        WebElement aktarmaSecimi = driver.findElement(By.xpath("//span[text()='Aktarmasız (direkt)']"));
        aktarmaSecimi.click();

        // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
        WebElement enUcuzCase = driver.findElement(By.xpath("//span[text()='En ucuz']"));
        enUcuzCase.click();

        WebElement fiyatText = driver.findElement(By.xpath("(//span[@class=' length-8'])[4]"));
        String fiyatstr = fiyatText.getText();
        fiyatstr= fiyatstr.replaceAll("\\D","");
        int fiyat = Integer.parseInt(fiyatstr);
        Assert.assertTrue(fiyat<5000);

    }


}
