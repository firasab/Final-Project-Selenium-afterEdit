package pages.DeletePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteCompanyPage {
    WebElement addBtn;

    public DeleteCompanyPage(WebDriver driver, int companyNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + companyNumber + "]/td[4]/button"));
        }catch (Exception e){
            System.out.println("We cant find this Company");
        }

    }

    public void deleteCompanyMethod(){
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("We cant find this button");
        }
    }
}

