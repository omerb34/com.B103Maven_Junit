package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P12_Actions3 extends TestBase {
//https://demoqa.com/ url'ine gidin.
    //Alerts, Frame & Windows Butonuna click yap
    //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
    //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
    //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
    //New Tab butonunun görünür olduğunu doğrula
    //New Tab butonuna click yap
    //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
    //İlk Tab'a geri dön
    ////New Tab butonunun görünür olduğunu doğrula


    @Test
    public void Test1() {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");


        //Alerts, Frame & Windows Butonuna click yap
        WebElement kutu = driver.findElement(By.xpath("(//*[@class='avatar mx-auto white'])[3]"));
        waitForVisibility(kutu,15);
        Actions action = new Actions(driver);
        //action.moveToElement(kutu).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();

        kutu.click();


        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement yazi = driver.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(yazi.isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='tabButton']")).isDisplayed());

        //New Tab butonuna click yap
        driver.findElement(By.xpath("//*[@id='tabButton']")).click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        /*
        Öncelikle bu soruda yenibir window açıldığını ve driverin oraya gönderilmesi gerektiğini unutmamal lazım.
        bunun için bütün pencereleri bir liste attık ve gitmek  istediğimiz pencereye index nosu ile gittik.
        pencere indexleri 0 dan baslamaktadır.bize lazımolan ikinci pencere onunda indexi 1 dir....*/
        List<String> allwindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allwindows.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        //İlk Tab'a geri dön
        driver.switchTo().window(allwindows.get(0));

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New Tab']")).isDisplayed());
    }
}

