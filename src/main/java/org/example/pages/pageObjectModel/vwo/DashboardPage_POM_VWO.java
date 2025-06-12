package org.example.pages.pageObjectModel.vwo;


import org.example.base.commonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage_POM_VWO extends commonToAllPage {

    WebDriver driver;
    Actions actions;

    public DashboardPage_POM_VWO(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators
    //  presenceOfElement(letsGoButton);
    // clickElement(letsGoButton);
    //vwo-modal-component//div//div//div//div//button[@class="btn btn--big btn--primary btn--inverted"]
    //WebElement letsGoButton = getElement("By", "//button[@class=\"btn btn--small btn--negative\"]");
    By userNameOnDashboard = By.cssSelector("span[data-qa='lufexuloga']");
    //WebElement closeModal = driver.findElement(By.xpath("//vwo-modal-component//div//div//div//div//button[@class=\"btn btn--big btn--primary btn--inverted\"]"));
    //span[@data-qa='lufexuloga']
     By closeModal = By.xpath("//vwo-modal-component//div//div//div//div//button[@class=\"btn btn--big btn--primary btn--inverted\"]");
    //WebElement letsGoButton = driver.findElement(By.xpath("//button[@class=\\\"btn btn--small btn--negative\\\"]"));
    //Page Actions
    public String loggedInUserName(){

        visibilityOfElement(closeModal);
        clickElement(closeModal);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }


}
