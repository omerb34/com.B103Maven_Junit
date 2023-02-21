package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    @Test
    public void newWindowHandleTest() {
//        1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://www.techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();

//       2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);// bu kod bize yeni bir pencere açar ve oraaya geçiş yapar....
        driver.get("https://amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

//        3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1. yeni pencere olusturu2. 2. Oraya gecis yapar
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        waitFor(3);


//        DRIVER NERDE? LINKEDINDE
//        TECHPRO SAYFASINA GITMEK ICIN TEKRAR driver.switchTo().window(techProHandle)
        driver.switchTo().window(techProHandle);
        waitFor(3);
//        DRIVER NERDE? TECHPRODA
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));//driverın burada olduğunu doğruladık...
        waitFor(3);



    }
}