package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {
    @Test
    public void iframeTest() {
       // Iframe nedir?
       // https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

       // Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String anaMetin=  driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();  //tag[.='metin']; Bana bu tagli metni ver
        //not:tag[text()='metin'];böyle de text locate alınabilinirdi.
      String expectedText=" black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

       // Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
            //öncelikle Applications lists elementi iframe in icinde. Iframe switch yapmam sart
        driver.switchTo().frame(0);//index 0 dan baslar. ilk iframe e switch yapiyoruz
        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText1="Applications lists";
        Assert.assertEquals(expectedText1,icMetin);
//  baska yollar       Alternatif olarak altdaki secenekler de kullanilabilir
//  baska 2.yol      Assert.assertTrue(expectedText1.contains(icMetin));
//   baska 3.yol     Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());


        //Son olarak anasayfada ‘Povered By’ yazisini varligini test ediniz.
        // (öncelikle yukarıdaki soruda driver iframnin ivinde kaldı burada öncelikle iframenin dıısına cıkmamız gerekecek bunu ise 2 yolla yaparız. )
        ////        Ana sayfadaki Povered By yazinisi test etmek istiyorum Ama driver hala iframein icinde
        ////        Iframein disina cikmak icin driver.switchTo().defaultContent/parentFrame
               driver.switchTo().defaultContent();
               String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
                System.out.println(footerText);
                Assert.assertTrue(footerText.contains("Povered By"));







    }
}
