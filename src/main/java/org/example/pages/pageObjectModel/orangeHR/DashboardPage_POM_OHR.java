package org.example.pages.pageObjectModel.orangeHR;

import org.example.base.commonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_POM_OHR extends commonToAllPage {

    WebDriver driver;

    public DashboardPage_POM_OHR(WebDriver driver){

        this.driver = driver;
    }

    //Page Locators
    By userNameOnDashboard = By.xpath("//h6[normalize-space()='PIM']");

    //Page Actions
    public String loggedInUsername(){
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}
