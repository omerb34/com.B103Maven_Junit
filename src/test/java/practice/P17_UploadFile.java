package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P17_UploadFile extends TestBase {
    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin


    @Test
    public void name() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");



        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz.

      // String farkliKisim=System.getProperty("user.home");
      // String ortakKisim="\\Desktop\\Mcafee seri numarası.txt";
      // String dosyaYolu= ortakKisim+farkliKisim;
        String dosyaYoluikinciYolu= "C:\\Users\\fatma\\Desktop\\Mcafee seri numarası.txt";
       WebElement dosyaSec=  driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
       dosyaSec.sendKeys(dosyaYoluikinciYolu);


        // I accept terms of service bölümünü tikleyin
        WebElement checkBox= driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();

    }
}
