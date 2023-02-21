package burakhocapracice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileDowland extends TestBase {
    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. some-file.txt dosyasini indirelim
    //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)

    @Test
    public void Test01() {

        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();

        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)

        String farklıKısım=System.getProperty("user.home");
        String ortakKısım="\\Downloads\\some-file.txt";

        String dosyaYolu2=farklıKısım+ortakKısım;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));


    }
}
