package Proje_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.Collections;
import java.util.Set;

public class Main extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("http://demowebshop.tricentis.com/");

        WebElement loginButton= driver.findElement(By.xpath("//div[@class='header-links']/ul/li[2]"));
        loginButton.click();

        WebElement email= driver.findElement(By.cssSelector("input#Email"));
        email.sendKeys("email");

        String ilkSayfaUrl=driver.getCurrentUrl();
        Set<String> windowHandles = Collections.singleton(driver.getCurrentUrl());

    }
}
