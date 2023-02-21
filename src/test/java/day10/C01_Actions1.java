package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {
  // Class: Actions1
  // Method: rightClick
  // https://the-internet.herokuapp.com/context_menu  sitesine gidin
  // Kutuya sag tıklayın
  // Alert’te cikan yazinin “You selected a context menu” oldugunu
  // test edin
  // Tamam diyerek alert’i kapatın

    @Test
    public void rightClick() {
        // https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Kutuya sag tıklayın
        Actions actions=new Actions(driver);
WebElement kutu= driver.findElement(By.xpath("//*[@id='hot-spot']"));
actions.contextClick(kutu).perform();

        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        // Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }
}
