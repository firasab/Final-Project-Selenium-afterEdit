package pages.LogIn;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage {
    WebElement email;
    WebElement password;
    WebElement loginBtn;
    TakeScreenShot takeScr;

    public LoginPage(WebDriver driver) {
        try {
            this.email = driver.findElement(By.name("email"));
        }catch (Exception e){
            System.out.println("there is a problem with the email");
        }
        try{
            this.password = driver.findElement(By.name("password"));
        }catch (Exception e){
            System.out.println("there is a problem with the password");
        }
        try{
            this.loginBtn = driver.findElement(By.xpath(Constants.LOGIN_XPATH_BTN));
        }catch (Exception e){
            System.out.println("there is a problem with the login button");
        }
        try{
            takeScr = new TakeScreenShot(driver);
        }catch (Exception e){
            System.out.println("there is a problem with the screenshot");
        }
    }

    public void loginMethod(String email, String password) throws InterruptedException, IOException {

        try{
            takeScr.takeScreenShot(Constants.PicturesFolderPath+"loginPage.png");
        }catch (Exception e){
            System.out.println("there is a problem with the screenshot");
        }
        try{
            this.email.sendKeys(email);
        }catch (Exception e){
            System.out.println("there is a problem with the email");
        }
        try{
            this.password.sendKeys(password);
        }catch (Exception e){
            System.out.println("there is a problem with the password");
        }
        try{
            this.loginBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with the loginBtn");
        }
    }
}

