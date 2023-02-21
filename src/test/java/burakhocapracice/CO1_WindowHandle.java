package burakhocapracice;

import org.junit.Test;
import utilities.TestBase;

public class CO1_WindowHandle extends TestBase {
    // 1- https://www.amazon.com sayfasına gidin
    // 2- nutella icin arama yapın
    // 3- yeni bir tab'da ilk urunun resmine tıklayınız
    // 4- yeni tab'da acilan urunun basligini yazdirin
    // 5- ilk sayfaya gecip url'i yazdırın


    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
    }
}
