package pages.EditPages;

import core.ClearField;
import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;

public class EditWorkerFormatPage {
    WebElement workerName;
    WebElement workerID;
    WebElement workerAddress;
    WebElement workerPhoneNumber;
    WebElement workerEmail;
    WebElement workerCompany;
    WebElement dateOfFinishingJob;
    WebElement image;
    WebElement addBtn;
    WebDriver driver;
    TakeScreenShot takeScr;

    public EditWorkerFormatPage(WebDriver driver) {
        try {
            this.driver = driver;
        }catch (Exception e){
            System.out.println("there is a problem with the driver");
        }
        try {
            workerName = driver.findElement(By.id("name"));
        }catch (Exception e){
            System.out.println("there is a problem with the name");
        }
        try {
            workerID = driver.findElement(By.id("id"));
        }catch (Exception e){
            System.out.println("there is a problem with the id");
        }
        try {
            workerAddress = driver.findElement(By.id("location"));
        }catch (Exception e){
            System.out.println("there is a problem with the location");
        }
        try {
            workerPhoneNumber = driver.findElement(By.id("phoneNumber"));
        }catch (Exception e){
            System.out.println("there is a problem with the phoneNumber");
        }
        try {
            workerEmail = driver.findElement(By.id("email"));
        }catch (Exception e){
            System.out.println("there is a problem with the email");
        }
        try {
            workerCompany = driver.findElement(By.id("companyName"));
        }catch (Exception e){
            System.out.println("there is a problem with the companyName");
        }
        try {
            dateOfFinishingJob = driver.findElement(By.id("mui-3"));
        }catch (Exception e){
            System.out.println("there is a problem with the dateOfFinishingJob");
        }
        try {
            image = driver.findElement(By.xpath(Constants.EDIT_WORKER_XPATH_IMG));
        }catch (Exception e){
            System.out.println("there is a problem with the image");
        }
        try {
            addBtn = driver.findElement(By.xpath(Constants.EDIT_WORKER_XPATH_BTN));
        }catch (Exception e){
            System.out.println("there is a problem with the addBtn");
        }
        try {
            takeScr = new TakeScreenShot(driver);
        }catch (Exception e){
            System.out.println("there is a problem with the TakeScreenShot");
        }
    }


    public void editWorkerMethod(String name, String id, String address, String phoneNumber, String email, String company, String dateOfFinishing, String path) throws InterruptedException, IOException {

        ClearField clear = new ClearField();
        try {
            clear.ClearCompanyField(this.workerName, driver);
            workerName.sendKeys(name);
        }catch (Exception e){
            System.out.println("there is a problem with the workerName");
        }

        try {
            clear.ClearCompanyField(this.workerID, driver);
            workerID.sendKeys(id);
        }catch (Exception e){
            System.out.println("there is a problem with the workerID");
        }

        try {
            clear.ClearCompanyField(this.workerAddress, driver);
            workerAddress.sendKeys(address);
        }catch (Exception e){
            System.out.println("there is a problem with the workerAddress");
        }

        try {
            clear.ClearCompanyField(this.workerPhoneNumber, driver);
            workerPhoneNumber.sendKeys(phoneNumber);
        }catch (Exception e){
            System.out.println("there is a problem with the workerPhoneNumber");
        }

        try {
            clear.ClearCompanyField(this.workerEmail, driver);
            workerEmail.sendKeys(email);
        }catch (Exception e){
            System.out.println("there is a problem with the workerEmail");
        }

        try {
            clear.ClearCompanyField(this.workerCompany, driver);
            workerCompany.sendKeys(company);
        }catch (Exception e){
            System.out.println("there is a problem with the workerCompany");
        }

        try {
            dateOfFinishingJob.sendKeys(dateOfFinishing);
        }catch (Exception e){
            System.out.println("there is a problem with the dateOfFinishing");
        }
        try {
            File file = new File(path);
            image.sendKeys(file.getAbsolutePath());
        }catch (Exception e){
            System.out.println("there is a problem with the image");
        }


        try {
            takeScr.takeScreenShot(Constants.PicturesFolderPath + "workerInformation.png");
        }catch (Exception e){
            System.out.println("there is a problem with the takeScreenShot");
        }

        try {
            addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with the addBtn");
        }
    }
}

