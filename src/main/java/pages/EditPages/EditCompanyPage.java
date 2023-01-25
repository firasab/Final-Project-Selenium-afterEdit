package pages.EditPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCompanyPage {
    WebElement addBtn;

    public EditCompanyPage(WebDriver driver, int companyNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + companyNumber + "]/td[4]/a[1]"));
        }catch (Exception e){
            System.out.println("we cant find this company");
        }
    }

    public void editCompanyMethod(){
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("we cant find this button");
        }
    }
}

