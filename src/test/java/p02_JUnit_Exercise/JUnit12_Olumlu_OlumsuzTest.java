package p02_JUnit_Exercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class JUnit12_Olumlu_OlumsuzTest extends TestBase {

    // https://www.automationexercise.com/  sayfasina gidelim
    // signUp linkine tiklayalim
    // name ve email adres kismine bilgiler gondererek uye olalim
    // uye olundugunu test edelim

    @Before
    public void setUp2(){

        // https://www.automationexercise.com/  sayfasina gidelim
        driver.get("https://www.automationexercise.com/");

        // signUp linkine tiklayalim
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        String expected = "https://www.automationexercise.com/login";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void olumluSenaryo(){

        // name ve email adres kismine bilgiler gondererek uye olalim
        WebElement nameBox = driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("Mehmet");

        WebElement emailBox = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailBox.sendKeys("mehmet@gmail.com");

        // uye olundugunu test edelim
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement enterAccountText = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountText.isDisplayed());

    }

    @Test
    public void olumsuzSenaryo(){

        //emailBox'da '@' yerine '.' yazildiginda uye olunmadigini test ediyorum
        WebElement nameBox = driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("Mehmet");

        WebElement emailBox = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailBox.sendKeys("mehmet.gmail.com");

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement newUserText = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserText.isDisplayed());

    }

    @Test
    public void olumsuzSenaryo2(){
        WebElement nameBox = driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("Mehmet");

        WebElement emailBox = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailBox.sendKeys("mehmet@gmailcom");

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement enterAccountText = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertFalse(enterAccountText.isDisplayed());
    }

}
