package Part1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;


public class ReadMe extends BaseStaticDriver {

    /*

        1) Bu siteye gidin. ->  http://demoqa.com/text-box

        2) Full Name kısmına "Automation" girin.

        3) Email kısmına "Testing" girin.

        4) Current Address kısmına "Testing Current Address" girin.

        5) Permanent Address kısmına "Testing Permanent Address" girin.

        6) Submit butonuna tıklayınız.

        7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
		ve Ekrana "**** Name Onaylandi ****" yazdirin. 
		degilse "**** Name Yanlis Girildi ****"

        8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.
		ve Ekrana "**** Email Onaylandi ****" yazdirin. 
		degilse "**** Email Yanlis Girildi ****"

     */

    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement fullname= driver.findElement(By.cssSelector("input[placeholder='Full Name']"));
        fullname.sendKeys("Automation");

        WebElement email= driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        email.sendKeys("Testing@example.com");

        WebElement currentAdress= driver.findElement(By.cssSelector("textarea[placeholder='Current Address']"));
        currentAdress.sendKeys("Testing Current Address");

        WebElement permanentAdress=driver.findElement(By.cssSelector("textarea[id='permanentAddress']"));
        permanentAdress.sendKeys("Testing Permanent Address");
        Thread.sleep(3000);


        WebElement submitButton= driver.findElement( By.id("submit"));
        submitButton.click();




        try {
            WebElement namText= driver.findElement(By.cssSelector("p[id='name']"));
            String nameText=namText.getText();
            Assert.assertTrue(nameText.contains("Automation"));
            System.out.println("Name Onaylandı");
        }catch (AssertionError e){
            System.out.println("Name Yanlış Girildi");
        }

        try {
            WebElement emailText=driver.findElement(By.cssSelector("p[id='email']"));
            String eT=emailText.getText();
            Assert.assertTrue(eT.contains("Testing"));
            System.out.println("Email Onaylandi");

        }catch (AssertionError e){
            System.out.println("Email Yanlis Girildi ");
        }



    }


}
