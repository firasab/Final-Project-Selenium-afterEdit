package pages.SendEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendRejectEmailPage {
    WebElement addBtn;


    public SendRejectEmailPage(WebDriver driver, int jobApplicationNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr[" + jobApplicationNumber + "]/td[8]/a[2]"));
        }catch (Exception e){
            System.out.println("there is a problem with the jobApplication");
        }
    }

    public void SendRejectEmailPageMethod(){
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with the button");
        }
    }
}

