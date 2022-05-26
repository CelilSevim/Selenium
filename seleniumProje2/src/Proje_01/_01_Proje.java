package Proje_01;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;

public class _01_Proje extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        WebElement username= driver.findElement(By.cssSelector("input[id='user_login']"));
        username.sendKeys("username");

        WebElement password= driver.findElement(By.cssSelector("input[id='user_password']"));
        password.sendKeys("password");

        WebElement sing_in= driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
        sing_in.click();

        driver.navigate().back();

        WebElement transferFunds= driver.findElement(By.cssSelector("span[id='transfer_funds_link']"));
        transferFunds.click();


        Thread.sleep(2000);

        WebElement fromAccount=driver.findElement(By.cssSelector("select[id='tf_fromAccountId']"));
        Select select= new Select(fromAccount);
        List<WebElement> options= select.getOptions();
        int random= (int) (Math.random()* (options.size()));
        options.get(random).click();

        Thread.sleep(2000);

        WebElement toAccount=driver.findElement(By.cssSelector("select[id='tf_toAccountId']"));
        Select select1=new Select(toAccount);
        List<WebElement> options1=select1.getOptions();
        int random1= (int) (Math.random()* (options1.size()));
        options1.get(random1).click();

        WebElement amount=driver.findElement(By.cssSelector("input[id='tf_amount']"));
        amount.sendKeys("2000");


        WebElement description=driver.findElement(By.cssSelector("input[id='tf_description']"));
        description.sendKeys("Hello Selenium");

        WebElement continueClick=driver.findElement(By.cssSelector("button[id='btn_submit']"));
        continueClick.click();

        Thread.sleep(2000);

        WebElement submit= driver.findElement(By.cssSelector("button[id='btn_submit']"));
        submit.click();



        try {
            WebElement text= driver.findElement(By.cssSelector("div[class='alert alert-success']"));
            String text1= text.getText();
            System.out.println(text1);
            Assert.assertEquals(text1,"You successfully submitted your transaction.");
            System.out.println("Tset başarılı Şekilde Tamamlandı");
        }catch (AssertionError e){
            System.out.println("Test Hatalı");
        }

        Thread.sleep(2000);
        driver.quit();






    }

}