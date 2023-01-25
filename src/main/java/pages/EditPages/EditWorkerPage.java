package pages.EditPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditWorkerPage {
    WebElement addBtn;


    public EditWorkerPage(WebDriver driver, int workerNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + workerNumber + "]/td[8]/a[1]"));
        }catch (Exception e){
            System.out.println("we cant find the worker");
        }
    }

    public void editWorkerMethod(){
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("we cant find the button");
        }
    }
}

