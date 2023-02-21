package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class SerbestCalisma extends TestBase {

    @Test
    public void Test1() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Soru1: Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String anaMetin = driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']")).getText();
        String exceptedText = "black border";
        Assert.assertTrue(anaMetin.contains(exceptedText));

        //Soru:2 Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim.
        /*
        Burada dikkat edilmesi gereken bir husus vardır. öncelikle sayfada bir iframe var mı yokmu ona bakmalıyız.İframe varsa direk locate alamayız.
        Çünkü Bir sayfada iframe varsa, Selenium bir iframe içindeki elementleri doğrudan göremez,
        Yapmamız gereken  iframe gördüğümüz yerin içine iframe.toSwitch yapmak kuyuya girmek  olmalıdır.
       */
        driver.switchTo().frame(0);
        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String Expected1 = "Applications lists";
        Assert.assertEquals(Expected1, icMetin);

        //Soru 3: anasayfada ‘Povered By’ yazisini varligini test ediniz.
        /* (öncelikle yukarıdaki soruda driver iframnin icinde kaldı burada öncelikle iframenin dıısına cıkmamız gerekecek bunu ise 2 yolla yaparız. )
             Iframein disina cikmak icin driver.switchTo().defaultContent/parentFrame dan birini kullanabilliriz...
         */
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));

    }
}
