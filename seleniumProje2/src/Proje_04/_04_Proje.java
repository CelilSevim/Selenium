package Proje_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;


import java.util.ArrayList;
import java.util.List;

public class _04_Proje extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
        /*
        WebElement ee= driver.findElement(By.cssSelector("ul[id='box1']"));
        String a=ee.getAttribute("style");
        System.out.println(a);

         */
        List<WebElement> teams = driver.findElements(By.xpath("//div[@id='dhtmlgoodies_mainContainer']/div/ul"));
        for (WebElement team : teams) {
            System.out.println(team.getAttribute("style"));
        }
       /*
        List<WebElement> teamKutu = driver.findElements(By.cssSelector("div[id='dhtmlgoodies_mainContainer']>div"));
        List<WebElement> student = driver.findElements(By.cssSelector("ul[id='allItems']>li"));
        WebElement[][] webElements = new WebElement[5][];
        webElements[0] = new WebElement[4];
        webElements[1] = new WebElement[4];
        webElements[2] = new WebElement[4];
        webElements[3] = new WebElement[3];
        webElements[4] = new WebElement[6];

        Thread.sleep(1000);
        Actions builder = new Actions(driver);

        int ogrSayi = 0;

        for (int i = 0; i < webElements.length; i++) {

            for (int j = 0; j < webElements[i].length; j++) {
                builder.clickAndHold(student.get(ogrSayi)).moveToElement(teamKutu.get(i)).release(teamKutu.get(i)).build().perform();
                ogrSayi++;
                if (j == webElements[i].length) break;
            }
        }


        */











    }

}