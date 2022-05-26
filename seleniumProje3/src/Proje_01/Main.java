package Proje_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class Main extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get(" https://app.hubspot.com/signup-hubspot/crm?loginRedirectUrl=undefined&step=landing_page");

        WebElement singUpButton= driver.findElement(By.xpath("//i18n-string[text()='Sign in']"));
        singUpButton.click();

        WebElement email= driver.findElement(By.cssSelector("input#username"));
        email.sendKeys("celilsvmm@gmail.com");

        WebElement pass= driver.findElement(By.cssSelector("input#password"));
        pass.sendKeys("7869572410Cc");

        WebElement loginButton= driver.findElement(By.cssSelector("button#loginBtn"));
        loginButton.click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement letsGoBut=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[@class='uiButton private-button private-button--primary private-button--default private-button--non-link']"))));

        letsGoBut.click();

        WebElement sales= driver.findElement(By.cssSelector("a#nav-primary-sales-branch>:nth-child(1)"));
        sales.click();

        WebElement deais= driver.findElement(By.cssSelector("a#nav-secondary-deals>:nth-child(1)"));
        deais.click();

        WebElement createDealsButton= driver.findElement(By.cssSelector("button[class='uiButton private-button private-button--primary private-button--sm add-obj private-button--non-link']"));
        createDealsButton.click();

        //driver.navigate().refresh();

        WebElement dealsName= driver.findElement(By.cssSelector("div.private-expandable-text"));
        dealsName.sendKeys("celil");

        WebElement salespipline=driver.findElement(By.xpath("//span[text()='Sales Pipeline'][1]"));
        salespipline.click();





    }
}
