package pages;

import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminDetails {
    WebElement Name;
    WebElement Email;


    public AdminDetails(WebDriver driver, int adminNumber) {
        try {
            this.Name = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + adminNumber + "]/th"));
        }catch (Exception e){
            System.out.println("we cant find the element");
        }
        try{
            this.Email = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+adminNumber+"]/td[1]"));
        }catch (Exception e){
            System.out.println("we cant find the element");
        }

    }

}

