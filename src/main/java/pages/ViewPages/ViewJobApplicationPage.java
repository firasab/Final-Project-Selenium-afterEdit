package pages.ViewPages;
import core.Constants;
import core.WriteCsvFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class ViewJobApplicationPage {
    WebElement PersonName;
    WebElement JobTitle;
    WebElement ID;
    WebElement PhoneNumber;
    WebElement Email;
    WebElement Address;
    WebElement Note;


    public ViewJobApplicationPage(WebDriver driver, int jobApplicationNumber) {
        try{
            this.PersonName = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/th"));
        }catch (Exception e){
            System.out.println("there is a problem with the PersonName");
        }
        try{
            this.JobTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/td[1]"));
        }catch (Exception e){
            System.out.println("there is a problem with the JobTitle");
        }
        try{
            this.ID = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/td[2]"));
        }catch (Exception e){
            System.out.println("there is a problem with the ID");
        }
        try{
            this.PhoneNumber = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/td[3]"));
        }catch (Exception e){
            System.out.println("there is a problem with the PhoneNumber");
        }
        try{
            this.Email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/td[4]"));
        }catch (Exception e){
            System.out.println("there is a problem with the Email");
        }
        try{
            this.Address = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/td[5]"));
        }catch (Exception e){
            System.out.println("there is a problem with the Address");
        }
        try{
            this.Note = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/td[6]"));
        }catch (Exception e){
            System.out.println("there is a problem with the Note");
        }
    }

    public void getJobsApplicationPageMethod() throws InterruptedException {

        String[] headers = new String[7];
        headers[0] = "PersonName";
        headers[1] = "JobTitle";
        headers[2] = "ID";
        headers[3] = "PhoneNumber";
        headers[4] = "Email";
        headers[5] = "Address";
        headers[6] = "Note";

        String[] website_data = new String[7];
        website_data[0] = PersonName.getText();
        website_data[1] = JobTitle.getText();
        website_data[2] = ID.getText();
        website_data[3] = PhoneNumber.getText();
        website_data[4] = Email.getText();
        website_data[5] = Address.getText();
        website_data[6] = Note.getText();
        List<String[]> data = new ArrayList<String[]>();
        data.add(website_data);
        try{
        WriteCsvFile.writeDataLineByLine(Constants.WriteFolderPath+"jobApplicationInfo.csv", data, headers);
    }catch (Exception e){
            System.out.println("there is a problem with the write a file");
        }
    }
}
