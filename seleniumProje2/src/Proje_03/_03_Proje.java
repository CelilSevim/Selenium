package Proje_03;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;


import java.util.List;
import java.util.Random;

public class _03_Proje extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        WebElement username= driver.findElement(By.cssSelector("input[id='user_login']"));
        username.sendKeys("username");

        WebElement password= driver.findElement(By.cssSelector("input[id='user_password']"));
        password.sendKeys("password");

        WebElement sing_in= driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
        sing_in.click();

        driver.navigate().back();

        WebElement onlineBanking=driver.findElement(By.cssSelector("li[id='onlineBankingMenu']"));
        onlineBanking.click();

        WebElement payBills=driver.findElement(By.cssSelector("span[id='pay_bills_link']"));
        payBills.click();

        Thread.sleep(2000);

        WebElement purchaseForeignCurrency =driver.findElement(By.cssSelector("ul[class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']>:nth-child(3)"));
        purchaseForeignCurrency.click();

        Thread.sleep(1000);

        WebElement currency=driver.findElement(By.cssSelector("select[id='pc_currency']"));
        Select select=new Select(currency);
        List<WebElement> options= select.getOptions();
        Random rastgele = new Random();
        int rastgeleSayi = rastgele.nextInt(options.size())+1;
        options.get(rastgeleSayi).click();

        WebElement amount= driver.findElement(By.cssSelector("input[id='pc_amount']"));
        amount.sendKeys("2000");

        WebElement dolar= driver.findElement(By.cssSelector("input[id='pc_inDollars_true']"));
        dolar.click();

        WebElement purchaseButton= driver.findElement(By.cssSelector("input[id='purchase_cash']"));
        purchaseButton.click();

        try {
            WebElement text= driver.findElement(By.cssSelector("div[id='alert_content']"));
            String text1= text.getText();
            System.out.println(text1);
            Assert.assertEquals(text1,"Foreign currency cash was successfully purchased.");
            System.out.println("Tset başarılı Şekilde Tamamlandı");
        }catch (AssertionError e){
            System.out.println("Test Hatalı");
        }

        Thread.sleep(2000);
        driver.quit();




    }

}