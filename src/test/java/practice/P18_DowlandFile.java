package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P18_DowlandFile extends TestBase {

    //https://www.selenium.dev/downloads/ adresine gidelim
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım


    @Test
    public void name() throws InterruptedException {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser= driver.findElement(By.xpath("(//*[@type='button'])[83]"));
        Actions action= new Actions(driver);
        action.moveToElement(browser).perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        Thread.sleep(1000);


        //All versions available in Downloads altında Latest stable release olan linki tıklayalım.
        driver.findElement(By.xpath("(//a[@class='XqQF9c'])[2]")).click();

        List<String> pencereler= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));

        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath(" //*[text()='chromedriver_win32.zip']")).click();
        waitFor(5);

        //Driver'in indiğini doğrulayalım.  //"C:\Users\fatma\Downloads\chromedriver_win32 (7).zip"
        String dosyayolu="C:\\Users\\fatma\\Downloads\\chromedriver_win32 (7).zip";
        assert Files.exists(Paths.get(dosyayolu));

    }
}
