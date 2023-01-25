package pages.ViewPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ViewCompanyPage {
    WebElement addBtn;
    TakeScreenShot takeScr;

    public ViewCompanyPage(WebDriver driver, int companyNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + companyNumber + "]/td[4]/a[2]"));
        }catch (Exception e){
            System.out.println("there is a problem with the addBtn");
        }
        try{
            takeScr = new TakeScreenShot(driver);
        }catch (Exception e){
            System.out.println("there is a problem with the TakeScreenShot");
        }
    }

    public void viewCompanyMethod() throws  IOException {
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with the addBtn");
        }

       try{
           takeScr.takeScreenShot(Constants.PicturesFolderPath+"newWorkerProfile.png");
       }catch (Exception e){
           System.out.println("there is a problem with the TakeScreenShot");
       }
    }
}

