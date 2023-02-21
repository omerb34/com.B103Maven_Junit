package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {
    @Test
    public void acceptAlertTest() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //  a) 1. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        // b) uyarıdaki OK butonuna tıklayın,
        Thread.sleep(5000);
        driver.switchTo()// DEĞİŞTİR
                .alert()//ALERT DEĞİŞTİR
                .accept();//ok secegine kutucuguna tıkladık. normalde bu element degıl o yuzden locate alamadık.
        Thread.sleep(5000);

        //  c)  ve result mesajının,“You successfully clicked an alert” oldugunu test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResult);
    }
    /* NOT...
    *Alertleri nasil automate edersin? How to handle alerts in selenium?
    -Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
     */

}

