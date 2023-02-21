package burakhocapracice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C06_Faker extends TestBase {
    // 'https://www.facebook.com' sayfasina gidiniz
    // yeni hesap olustur butonuna basin
    // isim kutusunu locate ediniz
    // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun


    @Test
    public void Test01() {
        driver.get("https://www.facebook.com");

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // isim kutusunu locate ediniz
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        isimKutusu.click();

        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun

        Faker faker = new Faker();

        String email = faker.internet().emailAddress();

        Actions actions = new Actions(driver);

        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("20").
                sendKeys(Keys.TAB).
                sendKeys("Ocak").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

// not:bu soruda aşağıdaki gibi dropdown da kullanılabikirdi hatta daha doğru olurdu bu kısımı incele

        // WebElement dayDropdown = driver.findElement(By.xpath("//*[@id='day']"));
        // Select selectDay = new Select(dayDropdown);
        // selectDay.selectByIndex(faker.number().numberBetween(0,30));

        // WebElement monthDropdown = driver.findElement(By.xpath("//*[@id='month']"));
        // Select selectMonth = new Select(monthDropdown);
        // selectMonth.selectByIndex(faker.number().numberBetween(0,11));

    }


}

