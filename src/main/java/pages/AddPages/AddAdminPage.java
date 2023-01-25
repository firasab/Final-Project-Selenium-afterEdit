package pages.AddPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class AddAdminPage {
    WebElement adminName;
    WebElement adminEmail;
    WebElement adminID;
    WebElement adminFirstPassWord;
    WebElement adminSecPassWord;
    WebElement addBtn;
    TakeScreenShot takeScr;

    public AddAdminPage(WebDriver driver) {
        try {
            adminName = driver.findElement(By.id("name"));
        }catch (Exception e){
            System.out.println("there is a problem with the admin name");
        }

        try {
            adminEmail = driver.findElement(By.id("email"));
        }catch (Exception e){
        System.out.println("there is a problem with the admin email");
    }
        try {
            adminID = driver.findElement(By.id("id"));
        }catch (Exception e){
            System.out.println("there is a problem with the admin id");
        }

        try {
            adminFirstPassWord = driver.findElement(By.id("password1"));
        }catch (Exception e){
            System.out.println("there is a problem with the admin password");
        }

        try {
            adminSecPassWord = driver.findElement(By.id("password2"));
        }catch (Exception e){
            System.out.println("there is a problem with the admin password");
        }

        try {
            addBtn = driver.findElement(By.xpath(Constants.ADD_ADMIN_XPATH_BTN));
        }catch (Exception e){
            System.out.println("there is a problem with the button");
        }

        try {
            takeScr = new TakeScreenShot(driver);
        }catch (Exception e){
            System.out.println("there is a problem with the screenshot");
        }
    }

    public void addAdminMethod(String adminName, String adminEmail, String adminID, String adminFirstPassWord, String adminSecPassWord) throws IOException {
        try {
            this.adminName.sendKeys(adminName);
        }catch (Exception e){
            System.out.println("please add admin name");
        }

        try {
            this.adminEmail.sendKeys(adminEmail);
        }catch (Exception e){
            System.out.println("please add admin email");
        }

        try {
            this.adminID.sendKeys(adminID);
        }catch (Exception e){
            System.out.println("please add admin ID");
        }

        try {
            this.adminFirstPassWord.sendKeys(adminFirstPassWord);
        }catch (Exception e){
            System.out.println("please add admin password");
        }

        try {
            this.adminSecPassWord.sendKeys(adminSecPassWord);
        }catch (Exception e){
            System.out.println("please add admin password approve");
        }

        try {
            takeScr.takeScreenShot(Constants.PicturesFolderPath + "adminInformation.png");
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with your screenshot");
        }
    }
}

