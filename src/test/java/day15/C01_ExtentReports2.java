package day15;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;
import java.text.SimpleDateFormat;
import java.util.Date;
public class C01_ExtentReports2 extends TestBase {
    //    HATIRLAMAMIZ GEREKEN 3 CLASS
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass

    public static void extentReportsSetUp(){
//      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
//       *************************************RAPORU CUSTOMIZE EDEBILIRIZ*********************
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechPro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Takim","Eagles");
        extentReports.setSystemInfo("Epic","Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi","Sprint-145");
        extentReports.setSystemInfo("QA","Ahmet");
//        *********************************EXTRA RAPOR ISMI VE DOCUMAN ISMI EKLEYEBILIRIZ****
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");
//        ********************************RAPOR AYARLARI BITTI****************************
//        Raporu projeme ekliyorum
        extentReports.attachReporter(extentHtmlReporter);
//        Extent Test objesi ni olustur
        extentTest = extentReports.createTest("Extent Report Login Test","Smoke Test Raporu");

    }
    @Test
    public void extentReportsTest(){
        extentTest.pass("PASS");
        extentTest.info("BILGILENDIRME NOTU");
        extentTest.fail("FAILED");
        extentTest.warning("UYARI MESAJI");
        extentTest.skip("ATLAMA MESAJI");
    }
    @AfterClass
    public static void extentReportsTearDown(){
        extentReports.flush();
    }

}
 // Raporlaramalari nasıl yaparsın?
 //     Manual testing yaparken elle ekran goruntusu alip work documanina eklerim. Sonra bu raporları JIRA ya user storye yüklerim
 //     Otomasyonda ise Extent Reports ile html raporlarını cikartip
 //     Extent Reports raporlari değiştirilebilir, özel proje bilgiler eklenebilir raporlardır
 //     Projemde ki raporlama sistemi, test case fail ettiginde otomatik olarak ekran goruntusunu alacak sekilde ayarladim
 //     Extent Reports kullanmanın avantajları nelerdir? Neden Extent Reports i tercih ettiniz?
 //     Open source- Ücretsiz
 //     Farkli browserlar yada islerim sistemleriyle calisabilir
 //     Junit, testng, cucumber gibi farklı test otomasyon frameworkleriyle entegre olabilir
 //     Her bir test adimini log(rapora yazdirma) yapabiliriz
 //     Customizable-Editlenebilir
 //     Extent reports ile raporlama islemi nasil gerceklesir? Bilgi verirmisiniz?
 //     Oncelikle maven projeleri icin Extent reports dependency oluşturmamız gerekmektedir
 //     Reusable classimda extent reports ile alakalı reusable metotlarım var. Bu metotlar yardımıyla raporlarım oluşuyor.
 //     3 onemli class vardır:
 //     Extent reports
 //     Extent Html Reporter.  ====>>>>>>> are user for generation the reports
 //     Extent Tess
 //     Bu sınıflar yardımıyla, platform, browser, environment, tester, takim bilgileri gibi özel proje bilgileri ekleyebilirim. Ayrıca extent test objesi kullanarak pass, fail, skip gibi loglamalar yapabilirim.
 //     Dependency lerini nerden alıyorsun?
 //     Şirkette internal bir repository miz var. Bu repodan ihtiyacım olacak dependencyi alıp kullanırım.
 //     Dependency sirket reposunda yoksa ne yapılır?
 //     Istedigim dependency icin istekde bulunuyorum. Managerlerin onayından sonra eklenen dependencyleri kullanıyorum.