package pages.AddPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;

public class AddWorkerPage {
    WebElement workerName;
    WebElement workerID;
    WebElement workerAddress;
    WebElement workerPhoneNumber;
    WebElement workerEmail;
    WebElement workerCompany;
    WebElement dateOfStartingJob;
    WebElement dateOfFinishingJob;
    WebElement image;
    WebElement addBtn;
    TakeScreenShot takeScr;

    public AddWorkerPage(WebDriver driver) {
        try {
            this.workerName = driver.findElement(By.id("name"));
        }catch (Exception e){
            System.out.println("There is a problem with the worker name");
        }
        try {
            this.workerID = driver.findElement(By.id("id"));
        }catch (Exception e){
            System.out.println("There is a problem with the worker id");
        }
        try {
            this.workerAddress = driver.findElement(By.id("location"));
        }catch (Exception e){
            System.out.println("There is a problem with the worker location");
        }
        try {
            this.workerPhoneNumber = driver.findElement(By.id("phoneNumber"));
        }catch (Exception e){
            System.out.println("There is a problem with the worker phoneNumber");
        }
        try {
            this.workerEmail = driver.findElement(By.id("email"));
        }catch (Exception e){
            System.out.println("There is a problem with the worker email");
        }
        try {
            this.workerCompany = driver.findElement(By.id("companyName"));
        }catch (Exception e){
                System.out.println("There is a problem with the worker companyName");
            }
        try {
            this.dateOfStartingJob = driver.findElement(By.id("mui-5"));
        }catch (Exception e){
            System.out.println("There is a problem with the worker dateOfStartingJob");
        }
        try {
            this.dateOfFinishingJob = driver.findElement(By.id("mui-6"));
        }catch (Exception e){
            System.out.println("There is a problem with the worker dateOfFinishingJob");
        }
        try {
            this.image = driver.findElement(By.xpath(Constants.ADD_WORKER_XPATH_IMG));
        }catch (Exception e){
            System.out.println("There is a problem with the worker image");
        }
        try {
            this.addBtn = driver.findElement(By.xpath(Constants.ADD_WORKER_XPATH_BTN));
        }catch (Exception e){
            System.out.println("There is a problem with the worker addBtn");
        }
        try {
            takeScr = new TakeScreenShot(driver);
        }catch (Exception e){
            System.out.println("There is a problem with the worker takeScr");
        }
    }

    public void addNewWorkerMethod(String name, String id, String address, String phoneNumber, String email, String company, String dateOfStartingJob, String dateOfFinishingJob,String path) throws InterruptedException, IOException {
        try {
            this.workerName.sendKeys(name);
        }catch (Exception e){
            System.out.println("There is a problem with the worker name");
        }
        try {
            this.workerID.sendKeys(id);
        }catch (Exception e){
                System.out.println("There is a problem with the worker id");
            }
        try {
            this.workerAddress.sendKeys(address);
        }catch (Exception e){
            System.out.println("There is a problem with the worker address");
        }
        try {
            this.workerPhoneNumber.sendKeys(phoneNumber);
        }catch (Exception e){
            System.out.println("There is a problem with the worker phoneNumber");
        }
        try {
            this.workerEmail.sendKeys(email);
        }catch (Exception e){
            System.out.println("There is a problem with the worker email");
        }
        try {
            this.workerCompany.sendKeys(company);
        }catch (Exception e){
            System.out.println("There is a problem with the worker company");
        }
        try {
            this.dateOfStartingJob.sendKeys(dateOfStartingJob);
        }catch (Exception e){
            System.out.println("There is a problem with the worker dateOfStartingJob");
        }
        try {
            this.dateOfFinishingJob.sendKeys(dateOfFinishingJob);
        }catch (Exception e){
            System.out.println("There is a problem with the worker dateOfFinishingJob");
        }
        try {
            File file = new File(path);
            this.image.sendKeys(file.getAbsolutePath());
        }catch (Exception e){
            System.out.println("There is a problem with the worker image");
        }

        try {
            takeScr.takeScreenShot(Constants.PicturesFolderPath + "workerInformation.png");
        }catch (Exception e){
            System.out.println("There is a problem with the worker takeScreenShot");
        }
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("There is a problem with the worker addBtn");
        }
    }
}

