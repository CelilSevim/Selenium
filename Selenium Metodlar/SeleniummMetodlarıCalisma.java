package Calısma1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniummMetodlarıCalisma {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/hp/Selenium/Choreme-Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dia.com.tr/demo-talep-formu/");
        driver.manage().window().maximize();
        Thread.sleep(5000);


        /*
        getAttribute :
            BU METOT HTML KODLARINNDA İCİNE YAZDIĞIMIZ ETİKETİN DEGERİNİ VERİYOR
            AŞAĞIDAKİ ÖRNEKTE name nin degeri olan ticari ünvanı bize veriyor

         */
       WebElement ee= driver.findElement(By.cssSelector("input[type='text']"));
        String a=ee.getAttribute("name");
        System.out.println("getAttiribute 'name' = "+a);

        /*
        getClass ():
                Komut, Class nesnesini almak için kullanılır
         */
        Thread.sleep(2000);
        WebElement classMethodu= driver.findElement(By.cssSelector("input[type='text']"));
        String classmethodu=classMethodu.getClass().getSimpleName();
        System.out.println("classmethodu"+classmethodu);

        /*
        getCurrentUrl ()
                • Komut, kullanıcının şu anda erişmekte olduğu web sayfasının URL'sini almak için kullanılır
                • Komut herhangi bir parametre gerektirmez ve bir dize değeri döndürür

         */
        Thread.sleep(2000);
        String url=driver.getCurrentUrl();
        System.out.println(url);

        Thread.sleep(2000);
        /*
        getPageSource ()
            Komut, sayfa kaynağını almak için kullanılır
            kullanıcının şu anda erişmekte olduğu web sayfasının
            • Komut herhangi bir parametre gerektirmez ve bir dize değeri döndürür
            • Komut, include () gibi çeşitli dize işlemleriyle birlikte kullanılabilir.
         */

        /*
        String pageSource=driver.getPageSource();
        System.out.println(pageSource);
        çok uzun oldugu icin yoruma aldım
         */

        /*
        getTitle ()
                    • Komut, kullanıcının şu anda üzerinde çalıştığı web sayfasının başlığını almak için kullanılır.
                      Web sayfasının başlığı yoksa boş bir dize döndürülür
                    • Komut herhangi bir parametre gerektirmez ve kesilmiş bir dize değeri döndürür
         */
        String title= driver.getTitle();
        System.out.println("Sayfanın Başlığı = "+title);

        /*
        getText ()

          • Komut, iç metni almak için kullanılır
            belirtilen web öğesinin
            • Komut herhangi bir parametre gerektirmez ve bir dize değeri döndürür
            • Ayrıca görüntülenen mesajların, etiketlerin, hataların vb. Doğrulanması için yaygın olarak kullanılan komutlardan biridir.
            web sayfalarında.
            */
        Thread.sleep(3000);
        WebElement text = driver.findElement(By.cssSelector("span[style='font-size: 14pt;']"));
        String texxt=text.getText();
        System.out.println("Bu lokasyondaki metin "+texxt);








        //driver.quit();
    }
}
