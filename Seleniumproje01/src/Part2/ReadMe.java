package Part2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class ReadMe extends BaseStaticDriver {

    /*
        1) Bu siteye gidin. -> https://demo.applitools.com/

        2) Username kısmına "krafttechno@gmail.com" girin.

        3) Password kısmına "techno123." girin.

        4) "Sign in" buttonunan tıklayınız.

        5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.(Assert kullanın )

        6) URL'in bu olduğunu doğrulayın. -> https://demo.applitools.com/app.html   (Assert kullanın )
     */
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demo.applitools.com/");
        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("krafttechno@gmail.com");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("techno123.");

        WebElement sing_in= driver.findElement(By.id("log-in"));
        sing_in.click();

        try {
            WebElement text=driver.findElement(By.id("time"));
            String text2=text.getText();
            Assert.assertTrue(text2.contains("Your nearest branch"));
            System.out.println("Giriş Başarılı Şekilde yapıldı");
        }catch (AssertionError e){
            System.out.println("Giriş Yapılırken Hata Oluştu");
        }
        Thread.sleep(2000);

        try {
            String url=driver.getCurrentUrl();
            Assert.assertTrue(url.equalsIgnoreCase("https://demo.applitools.com/app.html"));
            System.out.println("Doğru Sayfadasınız");
        }catch (AssertionError e){
            System.out.println("Farklı Bir Sayfadasınız");
        }

    }
}
