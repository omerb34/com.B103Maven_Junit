package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {
//EXPECTED RESULT (beklenen sonucun), ACTUAL RESULT (gerçek sonuca)

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1.)   Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {
        //  Then new butonuna basar
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='New']")).click();
        //    And editor firstname kutusuna "<firstName>" bilgileri girer
        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        //    And editor position kutusuna "<position>" bilgileri girer
        //    And editor office kutusuna "<office>" bilgileri girer
        //    And editor extension kutusuna "<extension>" bilgileri girer
        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        //    And editor salary kutusuna "<salary>" bilgileri girer
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='DTE_Field_first_name']")).
                sendKeys("Jenifer", Keys.TAB, "Lopez", Keys.TAB, "Singer",
                        Keys.TAB, "MTV", Keys.TAB, "MiM", Keys.TAB, "2010-05-08", Keys.TAB, "100000");
        Thread.sleep(2000);
        //    When Create tusuna basar
        driver.findElement(By.xpath("//button[@class='btn']")).click();
        //    Then Kullanıcının eklendiğini doğrular.
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Jenifer Lopez");
        WebElement actualyNAme = driver.findElement(By.className("sorting_1"));
        String acname = actualyNAme.getText();
        String expectedNAme = "Jenifer Lopez";
        Assert.assertEquals(acname, expectedNAme);


    }

    @Test
    public void test02() throws InterruptedException {
        //    And Eklediği kullanıcı kaydını siler
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Jenifer Lopez");
        driver.findElement(By.className("sorting_1")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Delete']")).click();
        driver.findElement(By.xpath("//button[@class='btn']")).click();
        //    Then Kullanıcinin silindiğini doğrular.
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Jenifer Lopez");
        Assert.assertTrue(driver.findElement(By.xpath("//td[@class='dataTables_empty']")).isDisplayed());
    }
    }