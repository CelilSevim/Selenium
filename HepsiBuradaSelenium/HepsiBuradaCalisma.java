package Calısma1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HepsiBuradaCalisma extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.hepsiburada.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        WebElement giris= driver.findElement(By.xpath("//span[text()='Giriş Yap']"));
        giris.click();


        WebElement girisYap= driver.findElement(By.cssSelector("a[id='login']"));
        girisYap.click();


        WebElement email= driver.findElement(By.cssSelector("input[name='username']"));

        email.sendKeys("celilsvmm@gmail.com");

        WebElement girisButonu= driver.findElement(By.cssSelector("button[id='btnLogin']"));
        girisButonu.click();


        try {
            WebElement hosgeldiniz= driver.findElement(By.className("_8EhOpLNSY8WDom_J4mL6Y"));
            Assert.assertTrue(hosgeldiniz.getText().equalsIgnoreCase("Hoş geldiniz"));
            System.out.println("E posta Adresi Geçerlidir");
        }catch (Exception e){
            WebElement hataMesaji=driver.findElement(By.xpath("//div[text()='Geçerli bir e-posta adresi girmelisiniz.']"));
            System.out.println(hataMesaji.getText()+" Email Geçerli Değil");
        }



        WebElement password=driver.findElement(By.cssSelector("input[id='txtPassword']"));
        password.sendKeys("7869572410C");

        WebElement girisYap2=driver.findElement(By.cssSelector("button[id='btnEmailSelect']"));
        girisYap2.click();


        try {
            WebElement celilsevim=driver.findElement(By.className("sf-OldMyAccount-1k66b"));
            String hesapIsmi=celilsevim.getText();
            Assert.assertEquals("celil sevim", hesapIsmi);
            System.out.println("HepsiBurada Sistemine Başarı İle Giriş Yapıldı "+hesapIsmi);
        }catch (Exception e){
            WebElement hataMesajiSifre=driver.findElement(By.xpath("//div[text()='Girdiğiniz şifre eksik veya hatalı.']"));
            System.out.println(hataMesajiSifre.getText());
        }
        String firstWindow=driver.getWindowHandle();
        String firstWindowUrl= driver.getCurrentUrl();

        WebElement search= driver.findElement(By.cssSelector("div[class='desktopOldAutosuggestTheme-container'] input"));
        search.sendKeys("laptop");

        WebElement searchButton=driver.findElement(By.cssSelector("div[class='SearchBoxOld-buttonContainer']"));
        searchButton.click();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
        List<WebElement> urünler=driver.findElements(By.cssSelector("ul[class='productListContent-wrapper productListContent-grid-0'] li[id^='i']"));
        System.out.println(urünler.size());
        int random= (int) (Math.random()* urünler.size());
        System.out.println(random);


        driver.switchTo().alert().dismiss();

        System.out.println(urünler.get(random).getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ("arguments [0] .scrollIntoView ();",urünler.get(random));

        urünler.get(random).click();

        Set<String> allWindow= driver.getWindowHandles();

        for (String window:allWindow) {
            driver.switchTo().window(window);
        }
        WebElement seciliurun=driver.findElement(By.cssSelector("span[class='product-name']"));
        System.out.println(seciliurun.getText());

        WebElement urunFiyat=driver.findElement(By.cssSelector("span[class='price price-new hepsiburada']"));
        System.out.println("Ürünün Fiyatı = "+urunFiyat.getText());

        WebElement addToCart= (WebElement) driver.findElements(By.cssSelector("button[id='addToCart']"));

        addToCart.click();








        //driver.quit();




    }
}
