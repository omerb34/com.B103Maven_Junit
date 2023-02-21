package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C02_JavaFaker {

    @Test
    public void javaFakerTest() {

        //1..faker objesi olusturduk..
        Faker faker = new Faker();

        //2.first name datası girelim
        String fname = faker.name().firstName();
        System.out.println(fname);

        //3.kullanici adi
        String username = faker.name().username();
        System.out.println(username);

        //        meslek ismi
        System.out.println(faker.name().title());
//        sehir
        System.out.println(faker.address().city());
//        eyalet
        System.out.println(faker.address().state());
//        full address
        System.out.println(faker.address().fullAddress());
//        cep telefon numarasi
        System.out.println(faker.phoneNumber().cellPhone());
//        email
        System.out.println(faker.internet().emailAddress());
//        posta kodu
        System.out.println(faker.address().zipCode());
//        rasgele 15 haneli numara
        System.out.println(faker.number().digits(15));
/*
TEST DATA : kullanicai adi, sifre, tel no, email, sehir, kredi kart no,...
Test datalarini kimden alinir?
1. BA-Business analyst (Acceptance Criteria lari yazar)
2. Test Lead
3. Manual Tester
4. Tech Lead & Team Lead & Dev Lead
5. Developer
6. Database
7. API call lar
8. Documantasyonlar. Ognegin, API swagger documani.
9. Java Faker da fake data almak icin kullanyoruz
NERDEN GELMEZ : end user -kullanicidan, scrum master,
 */


    }
}
