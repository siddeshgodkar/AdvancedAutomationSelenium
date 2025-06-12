package org.example.tests.vwoTestCase;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.pages.pageObjectModel.vwo.LoginPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_POM {

    @Owner("Siddesh")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/");

        LoginPage_POM loginPagePom = new LoginPage_POM(driver);
        String error_msg = loginPagePom.loginToVWOLoginInvalidCreds("admin", "admin@123");

        assertThat(error_msg).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

        driver.quit();
    }
}
