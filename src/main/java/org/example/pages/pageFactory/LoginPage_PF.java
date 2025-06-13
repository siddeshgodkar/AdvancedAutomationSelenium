package org.example.pages.pageFactory;

import org.example.base.commonToAllPage;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends commonToAllPage {


    //param C
    public LoginPage_PF(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    //Page Locators
    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;

    //Page Actions
    public String loginToVWOInvalidCreds(){

        enterInput(username, PropertiesReader.readKey("invalid_username"));
        enterInput(password, PropertiesReader.readKey("invalid_password"));
        clickElement(signButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return error_message.getText();
    }

}
