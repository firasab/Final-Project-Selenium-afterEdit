package pages.DeletePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownloadExcelPage {
    WebElement search;

    public DownloadExcelPage(WebDriver driver) {
        try {
            this.search = driver.findElement(By.id("test-table-xls-button"));
        }catch (Exception e){
            System.out.println("We cant find this execl file");
        }
    }

    public void downloadExcelMethod()  {
        try {
            this.search.click();
        }catch (Exception e){
            System.out.println("We cant find this button");
        }

    }
}

