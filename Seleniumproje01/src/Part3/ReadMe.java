package Part3;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class ReadMe extends BaseStaticDriver {

    /*

        1) Bu siteye gidin. -> https://www.snapdeal.com/

        2) "teddy bear" aratın ve  Search butonuna tıklayın.

        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 918 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.

        4) Snepdeal logosuna tıklayınız.

        5) URL'in bu olduğunu doğrulayın. (https://www.snapdeal.com/)

     */
    public static void main(String[] args) throws InterruptedException {
        driver.get(" https://www.snapdeal.com/");
        WebElement search= driver.findElement(By.cssSelector("input[class='col-xs-20 searchformInput keyword']"));
        search.sendKeys("teddy bear");

        WebElement searchKey= driver.findElement(By.cssSelector("button[class='searchformButton col-xs-4 rippleGrey']"));
        searchKey.click();


        Thread.sleep(3000);

        try {
            WebElement text= driver.findElement(By.cssSelector("div[class='search-result-txt-section  marT12']"));
            String ttext=text.getText();
            Assert.assertTrue(ttext.contains("'teddy bear'"));
            System.out.println("Test İşlemi Tamamlandı");
        }catch (AssertionError e){
            System.out.println("Farklı Bir Sayfadasınız");
        }

        WebElement logo = driver.findElement(By.cssSelector("img[src='https://i3.sdlcdn.com/img/snapdeal/darwin/logo/sdLatestLogo.svg']"));
        logo.click();

        Thread.sleep(5000);



        try {
            String url=driver.getCurrentUrl();
            Assert.assertTrue(url.equalsIgnoreCase("https://www.snapdeal.com/"));
            System.out.println("Url Doğrulandı");
        }catch (AssertionError a){
            System.out.println("Farklı Bir Sayfadasınız");
        }
        

    }
}
