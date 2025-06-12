package org.example.tests.vwoTestCase.pageObjectModel_TestCase;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.pageObjectModel.vwo.DashboardPage_POM_VWO;
import org.example.pages.pageObjectModel.vwo.LoginPage_POM_VWO;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_POM extends CommonToAllTest {

    @Owner("Siddesh")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO(){



        LoginPage_POM_VWO loginPagePom = new LoginPage_POM_VWO(DriverManager.getDriver());
        String error_msg = loginPagePom.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        assertThat(error_msg).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message_vwo"));


    }


    @Owner("Siddesh")
    @Description("Verify that Valid creds sign in successfully")
    @Test
    public void testLoginPositiveVWO(){

        LoginPage_POM_VWO loginPagePom = new LoginPage_POM_VWO(DriverManager.getDriver());
        loginPagePom.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));

        DashboardPage_POM_VWO dashboardPagePom = new DashboardPage_POM_VWO(DriverManager.getDriver());
        String loggedInUsername = dashboardPagePom.loggedInUserName();

        assertThat(loggedInUsername).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(loggedInUsername, PropertiesReader.readKey("expected_username"));
    }
}
