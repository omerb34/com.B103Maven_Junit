package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P11_Actions2 extends TestBase {
    /*
            -http://spicejet.com/ sayfasına gidelim
            -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
            -Sayfa başlığının Fleet içerdiğini test edelim
         */
    @Test
    public void name() {
        //-http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

        //-Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement aboutUs = driver.findElement(By.xpath("//*[.='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        driver.findElement(By.xpath("//*[text()='Fleet']")).click();

        //-Sayfa başlığının Fleet içerdiğini test edelim
        String baslik = driver.findElement(By.xpath("(//*[.='Fleet'])[3]")).getText();
        Assert.assertTrue(baslik.contains("Fleet"));
    }
}

