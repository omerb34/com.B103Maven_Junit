package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void readExcelTest() throws Exception {
        //  sıralama==>  WORKBOOK (EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) >ROW (SATIR)> CELL(VERI

        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx";
        //dosyayı açtık
        FileInputStream fileInputStream = new FileInputStream(path);

        //excel dosyasını aç/worbook aç
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // sayfayı aç/sheet1
        //Sheet sheet1= workbook.getSheetAt(0);//ibdex ile git
        Sheet sheet1 = workbook.getSheet("Sheet1"); //string ile git

        //ilk satıra git/row
        Row row1 = sheet1.getRow(0); //ilk satıra götürdü index ile...

        //ilk veriyi al ve azdır.
        Cell cell1 = row1.getCell(0);//ilk hüzredeki datayı al
        System.out.println(cell1);

        //1.satır 2. sutuna gitmek için
        Cell cell2 = sheet1.getRow(0).getCell(1);
        System.out.println(cell2);

        //3. saır ve 1. sutun elemanını yazdırınız ve sonucun France olduğunu doğrula
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France", cell31);

        //Exceldeki toplam kullanilan satir sayisini bul
        int toplamSatirSayisi = sheet1.getLastRowNum() + 1;//son satir numarasi.index 0dan basliyor. sayma sayilari 1 den. +1 ekle
        System.out.println(toplamSatirSayisi);//11

        //Kullanılan toplam satır sayısını yazınız
        int kullanilanToplamStirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamStirSayisi);// yularıda index o dan başladığı için sonuc 10 çıkıyor ama burada index olayı yok

        //Country, capital keys ve valueları map a alıp print et
        Map<String, String> ulkeBaskentleri = new HashMap<>();
        for (int satirsayisi = 1; satirsayisi < kullanilanToplamStirSayisi; satirsayisi++) {
            String country = sheet1.getRow(satirsayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirsayisi).getCell(1).toString();
            ulkeBaskentleri.put(country, capital);
        }
        System.out.println(ulkeBaskentleri);
    }

}







