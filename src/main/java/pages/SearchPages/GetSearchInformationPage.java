package pages.SearchPages;
import core.Constants;
import core.WriteCsvFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetSearchInformationPage {
    WebElement name;
    WebElement ID;
    WebElement Location;
    WebElement PhoneNumber;
    WebElement Email;
    WebElement Company;
    WebElement StartedWorkingAt;
    WebElement FinishedWorkingAt;

    public GetSearchInformationPage(WebDriver driver) {
        try {
            this.name = driver.findElement(By.xpath(Constants.SEARCHED_NAME_XPATH));
        }catch (Exception e){
            System.out.println("there is a problem with the name ");
        }
        try {
            this.ID = driver.findElement(By.xpath(Constants.SEARCHED_ID_XPATH));
        }catch (Exception e){
            System.out.println("there is a problem with the ID ");
        }
        try{
            this.Location = driver.findElement(By.xpath(Constants.SEARCHED_LOCATION_XPATH));
        }catch (Exception e){
            System.out.println("there is a problem with the Location ");
        }
        try{
            this.PhoneNumber = driver.findElement(By.xpath(Constants.SEARCHED_PHONE_NUMBER_XPATH));
        }catch (Exception e){
            System.out.println("there is a problem with the PhoneNumber ");
        }
        try{
            this.Email = driver.findElement(By.xpath(Constants.SEARCHED_EMAIL_XPATH));
        }catch (Exception e){
            System.out.println("there is a problem with the Email ");
        }
        try{
            this.Company = driver.findElement(By.xpath(Constants.SEARCHED_COMPANY_XPATH));
        }catch (Exception e){
            System.out.println("there is a problem with the Company ");
        }
       try{
           this.StartedWorkingAt = driver.findElement(By.xpath(Constants.SEARCHED_START_WORK_DATE_XPATH));
       }catch (Exception e){
           System.out.println("there is a problem with the StartedWorkingAt ");
       }
        try{
            this.FinishedWorkingAt = driver.findElement(By.xpath(Constants.SEARCHED_FINISH_WORK_DATE_XPATH));
        }catch (Exception e){
            System.out.println("there is a problem with the FinishedWorkingAt ");
        }
    }

    public void getSearched() throws InterruptedException, IOException {


        String[] headers = new String[8];
        headers[0] = "Name";
        headers[1] = "ID";
        headers[2] = "Location";
        headers[3] = "Phone Number";
        headers[4] = "Email";
        headers[5] = "Company";
        headers[6] = "Started working at";
        headers[7] = "Finished working at";

        String[] website_data = new String[8];
        website_data[0] = name.getText();
        website_data[1] = ID.getText();
        website_data[2] = Location.getText();
        website_data[3] = PhoneNumber.getText();
        website_data[4] = Email.getText();
        website_data[5] = Company.getText();
        website_data[6] = StartedWorkingAt.getText();
        website_data[7] = FinishedWorkingAt.getText();
        List<String[]> data = new ArrayList<String[]>();
        data.add(website_data);
        try {
            WriteCsvFile.writeDataLineByLine(Constants.WriteFolderPath + "SearchInfo.csv", data, headers);
        }catch (Exception e){
            System.out.println("there is a problem with the screenshot");
        }
        try{
            WriteCsvFile.attachCsv(Constants.WriteFolderPath+"SearchInfo.csv","SearchInfo.csv");
        }catch (Exception e){
            System.out.println("there is a problem with the screenshot");
        }
    }
}
