package org.example.pages.pageObjectModel.vwo;

import org.example.base.commonToAllPage;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM_VWO extends commonToAllPage {

    WebDriver driver;

    public LoginPage_POM_VWO(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signInButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");
    //button[@class="btn btn--small btn--negative"]



    //Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd){

        driver.get(PropertiesReader.readKey("url"));
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signInButton);


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        String errorMessageText = driver.findElement(errorMessage).getText();
        return errorMessageText;

    }

    public void loginToVWOLoginValidCreds(String user, String pwd){
        driver.get(PropertiesReader.readKey("url"));
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signInButton);


        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }


    }

}
