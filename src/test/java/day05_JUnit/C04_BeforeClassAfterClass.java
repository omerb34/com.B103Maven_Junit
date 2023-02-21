package day05_JUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class C04_BeforeClassAfterClass {

/*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
    en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
*/

    @BeforeClass //Her classda static olarak calısır.Class içerisinde her şeyden ÖNCE ve sadece 1 kere calısır
    public static void setUp(){
        System.out.println("Butun testlerden once calisti");
    }

    @AfterClass//Her classda static olarak calısır.Class içerisinde her şeyden SONRA ve sadece 1 kere calısır
    public static void tearDown(){
        System.out.println("Butun testlerden sonra calisti");
    }

    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }

    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }

    @Test
    @Ignore //Çalıştırmak istemediğimiz testler için kullanırız
    public void test03(){
        System.out.println("Ikinci Test");
    }
}