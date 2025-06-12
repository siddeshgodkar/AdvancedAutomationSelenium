package org.example.pages.pageObjectModel.orangeHR;

import org.example.base.commonToAllPage;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM_OHR  extends commonToAllPage {

    //param cons
    WebDriver driver;

    public LoginPage_POM_OHR(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators
    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By submit_btn = By.xpath("//button[normalize-space()='Login']");

    //Page Actions
    public void loginToHRCreds(String user, String pwd){

        driver.get(PropertiesReader.readKey("orange_hr_url"));
        visibilityOfElement(username);
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(submit_btn);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
