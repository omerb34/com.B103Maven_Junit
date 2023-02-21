package day10;

public class ActionsOzet {

//                    ACTIONS CLASS'ı NEDİR? HANGİ METHODLAR İLR  NASIL KULLANILIR?..

//   Actions classını kullanarak klavye ve mouse ile yapabileciğiz tüm işlemleri otomosyonda da  yapmamızı sağlamaktayız..!!
//   Bu classa ait metdodlar kısaca aşağıdaki gibidir....

//       actions.doubleClick () :   WebElement’e çift tıklama yapar
//       actions.clickAndHold () :  Uzerinde click yapili olarak bekler
//       actions .dragAndDrop () :  Bir noktadan diğerine sürükler ve bırakır
//       actions.moveToElement () : Mouse’u istedigimiz WebElement’in uzerinde tutar
//       actions.contextClick ():   Mouse ile istedigimiz WebElement’e sag tiklama yapar.
//       actions.sendKeys() :       Öğeye bir dizi anahtar gönderir
//       actions.keyDown () :       Klavyede tuşa basma işlemi gerçekleştirir
//       actions.keyUp () :         Klavyede tuşu serbest bırakma işlemi gerçekleştirir
//
//
//        !!!!Actions classını kullanmak için üç aşama vardır.??

//     1.Action classından obje üretiriz.
//     (Actions actions= new Actions(driver);)
//     2.actions objesi ile kullanacağımız web elementi locate ederiz...
//     3.istediğimiz methodları action objesi ile kullanırız.
//     actions.doubleClick(element ismi).perform;
//
//
//      1- Actions nedir? Actions Class nedir ?
//      *Actions selenium dan gelen bir kütüphanedir. Mouse ve Keyboard islemlerini gerçekleştirmek icin kullandigimiz hazır bir selenium kutuphanesidir.
//      Ornegin, sag tiklamak(contextClick), çift tıklamak(doubleClick), elementin uzerine gitmek(moveToElement) gibi mouse islemlerini gerçekleştirebiliriz.
//      Ayni zamanda, shift, control, delete, enter gibi keyboard tuslarinada actions yardımıyla basabiliriz. Bu tur islemlerde sendKeys metodu kullaninir.

//      2- Ne tur methodlar kullandin?
//      Actions metotlari onemlidir. Ve tekrar tekrar kullanmam gerektiğinden,
//      Actions metotlarını içeren Reusable metodları oluşturdum.
//      Ve gerektiğinde bu reusable metodları kullanıyorum. Ornegin rightClick methodunu bir elemente raga tiklamak icin test classimda vagira bilirim.

//      3- Hangi methodlari kullandin ne ne ise yarar?
//      Ornegin, sag tiklamak(contextClick), çift tıklamak(doubleClick), elementin uzerine gitmek(moveToElement) gibi mouse islemlerini gerçekleştirebiliriz.
//      Ayni zamanda, shift, control, delete, enter gibi keyboard tuslarinada actions yardımıyla basabiliriz.
//      Bu tur islemlerde sendKeys metodu kullaninir.
//
//
//
//
//
//
//
//
//
}
