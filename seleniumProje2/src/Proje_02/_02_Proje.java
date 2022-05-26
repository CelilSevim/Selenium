package Proje_02;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;

public class _02_Proje extends BaseStaticDriver {
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

        WebElement payee=driver.findElement(By.cssSelector("select[id='sp_payee']"));
        Select select= new Select(payee);
        List<WebElement> option=select.getOptions();
        int random= (int) (Math.random() * option.size());
        option.get(random).click();

        Thread.sleep(1000);

        WebElement account=driver.findElement(By.cssSelector("select[id='sp_account']"));
        Select select1= new Select(account);
        List<WebElement> option1=select1.getOptions();
        int random1= (int) (Math.random() * option1.size());
        option.get(random1).click();


        WebElement amount=driver.findElement(By.cssSelector("input[id='sp_amount']"));
        amount.sendKeys("2000");

        WebElement date= driver.findElement(By.cssSelector("input[id='sp_date']"));
        date.sendKeys("2022-02-10");

        WebElement description=driver.findElement(By.cssSelector("input[id='sp_description']"));
        description.sendKeys("Hello Selenium");

        WebElement payButton=driver.findElement(By.cssSelector("input[id='pay_saved_payees']"));
        payButton.click();


        try {
            WebElement text= driver.findElement(By.cssSelector("div[id='alert_content']"));
            String text1= text.getText();
            System.out.println(text1);
            Assert.assertEquals(text1,"The payment was successfully submitted.");
            System.out.println("Tset başarılı Şekilde Tamamlandı");
        }catch (AssertionError e){
            System.out.println("Test Hatalı");
        }

        Thread.sleep(2000);
        driver.quit();







    }

}
