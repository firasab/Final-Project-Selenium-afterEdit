package pages.DeletePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DeleteWorkerPage {
    WebElement addBtn;

    public DeleteWorkerPage(WebDriver driver, int workerNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + workerNumber + "]/td[8]/button"));
        }catch (Exception e){
            System.out.println("We cant find this Worker");
        }
    }

    public void deleteWorkerMethod(){
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("We cant find this button");
        }
    }
}

