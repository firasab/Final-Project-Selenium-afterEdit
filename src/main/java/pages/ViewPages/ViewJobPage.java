package pages.ViewPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ViewJobPage {
    WebElement addBtn;
    TakeScreenShot takeScr;

    public ViewJobPage(WebDriver driver, int jobNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + jobNumber + "]/td[5]/a[2]"));
        }catch (Exception e){
            System.out.println("there is a problem with the write a addBtn");
        }

        try {
            takeScr = new TakeScreenShot(driver);
        }catch (Exception e){
            System.out.println("there is a problem with the write a TakeScreenShot");
        }
    }

    public void viewJobMethod() throws  IOException {

        try{
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with the write a addBtn");
        }

        try{
            takeScr.takeScreenShot(Constants.PicturesFolderPath+"newWorkerProfile.png");
        }catch (Exception e){
            System.out.println("there is a problem with the write a TakeScreenShot");
        }
    }
}

