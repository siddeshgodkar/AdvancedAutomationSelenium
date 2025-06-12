package org.example.pages.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM {

    WebDriver driver;

    public LoginPage_POM(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signInButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");


    //Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd){

        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        String errorMessageText = driver.findElement(errorMessage).getText();
        return errorMessageText;

    }
}
