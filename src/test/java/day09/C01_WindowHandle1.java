package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle1 extends TestBase {
    // https://the-internet.herokuapp.com/windows adresine gidin.
    // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // Click Here butonuna basın.
    // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

    @Test
    public void windowHandleTest() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        String windowHandle = driver.getWindowHandle();//(soruda ikinci pencere açıldığu için bu bşr kenarda durmalı)

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindow1Text = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        String expectedWindow1text = "Opening a new window";
        Assert.assertEquals(expectedWindow1text, actualWindow1Text);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualWindow1Title = driver.getTitle();
        String expectedWindow1Title = "The Internet";
        Assert.assertEquals(expectedWindow1Title, actualWindow1Title);


        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        //not:yukarıdaki kodu yazdıktan sonra yeni pencere açılmaktadır. ve ikinci pencereye geçiş yatık.

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        switchToWindow(1);//2. windowa gecis yapdik. driver artik 2. window da
        String actualWindow2Title = driver.getTitle();
        String expectedWindow2Title = "New Window";
        Assert.assertEquals(expectedWindow2Title, actualWindow2Title);
    }
}
