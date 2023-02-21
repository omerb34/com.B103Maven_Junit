package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_Practice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //SORU1:google adresine gidin
        driver.get("https://www.google.com");

        //Soru2:sayfa baslığının google ifadesi icerdiğini test edininiz.
        String baslik= driver.getTitle();
        if (baslik.contains("Goole")){
            System.out.println("tittle test passed");
        }else System.out.println("title past failed");

        //Soru3:Aramaçubuğuna nutella yazıp arataım.
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("nutella", Keys.ENTER);

//Soru4: Bulunan sonuc sayisini yazdirin.
        //id="result-stats
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
        List<String> liste = new ArrayList<String>(Arrays.asList(sonucSayisi.getText().split(" ")));
        System.out.println(liste.get(1));


        //soru:5 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin.

        String sonSonuc =liste.get(1).replaceAll("[\\p{Punct}]","");

        int yeniSonuc =Integer.parseInt(sonSonuc);

        if(yeniSonuc>10000000){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        //7
        driver.close();


}
    }