package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class IframeOdev extends TestBase {
    // Bir class olusturun: IframeOdev
    // https://the-internet.herokuapp.com/iframe  sitesine gidiniz
    // sayfadaki toplam iframe sayısını bulunuz.
    // Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
    // Paragrafdaki yaziyi silelim
    // Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
    // Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim


    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe ");

        // sayfadaki toplam iframe sayısını bulunuz.
        int iframeSayisi = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Sayfadaki toplam iframe sayısı=" + iframeSayisi);

        // Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String baslik=driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        String expected="Editor";
        Assert.assertTrue(baslik.contains(expected));

        // Paragrafdaki yaziyi silelim.
        driver.switchTo().frame(0);
       WebElement silme= driver.findElement(By.xpath("//p[.='Your content goes here.']"));
       silme.clear();
       Thread.sleep(5000);

        //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        silme.sendKeys("iframein icindeyim");


        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim.
        /*
        Yukarıda iframin içine nasıl switchto yapip girdiysek yeni işlemyapabilmek için de burada iframe'nin dışına driveri çıkarmamız gerekir.
        Aşağıdaki  driver.switchTo().parentFrame(); komutu bu yüzden yazıldı.
         */
        driver.switchTo().parentFrame();
        String textName = driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText();
        Assert.assertTrue(textName.contains("Elemental Selenium"));

    }
}
