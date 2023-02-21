package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void isExistTest() {

        String usrDIR=System.getProperty("user.dir");
        System.out.println(usrDIR); // C:\Users\fatma\IdeaProjects\com.B103Maven_Junit


        String userHome= System.getProperty("user.home");
        System.out.println(userHome);//C:\Users\fatma

        String dosyaYolu=userHome + "/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

       boolean isExist = Files.exists(Paths.get(dosyaYolu));// dosya varsa true yoksa false alacağız.
        Assert.assertTrue(isExist);

    }
}
