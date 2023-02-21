package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P19_Exception extends TestBase {

    // amazon sayfasına gidelim,
    //iphone aratalım
    //çıkaan ürünlerde sadece Apple iphone yazanları tıklayalım.

    @Test
    public void name(){
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Çıkan ürünlerde sadece Apple iPhone yazanları tıklayalım
        List<WebElement> urunler = driver.findElements(By.partialLinkText("Apple iPhone"));
        //TEXT İÇİNDE APPLE IPHONE YAZISI GEÇENLERİ ALICAK
        for (int i = 0; i < urunler.size(); i++) {
            urunler = driver.findElements(By.partialLinkText("Apple iPhone"));
            urunler.get(i).click();
            driver.navigate().back();
        }

        //Bu soruda for bütün elementlerialmak icin her bir iphone linkini bir linke atarız. ancak birden fazla ürün
        //karşımıza çıkacaktır. her bir ürüne tıklamamız için öncelikle tüm linkleri bir liste atarız sonrasında da bir for döngüsü
        //kurarız. haliyle çıkan her bir linke tıklama imkanı buluruz. döngüde geri gelip tık yapmak ıcınde bir navigate. back()
        // methodu kulllanmamız gerekir. ancak sistem geri gelirken bir exception atacaktır. işte bu exceptionu cozmek ıcın for
        // döngüsü altına element bulmak ıcın bir locate kodu koyduk
        }
    }

