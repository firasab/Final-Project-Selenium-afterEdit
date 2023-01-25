package pages.SendEmail;

import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailSenderPage {
    WebElement addBtn;


    public EmailSenderPage(WebDriver driver) {
        try {
            this.addBtn = driver.findElement(By.xpath(Constants.SEND_EMAIL_XPATH_BTN));
        }catch (Exception e){
            System.out.println("there is a problem with the add button");
        }
    }

    public void emailSenderPageMethod(){
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with the add button");
        }
    }
}

