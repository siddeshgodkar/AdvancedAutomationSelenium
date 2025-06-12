package org.example.tests.orangeHR.pageObjectModel_TestCase;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.pageObjectModel.orangeHR.DashboardPage_POM_OHR;
import org.example.pages.pageObjectModel.orangeHR.LoginPage_POM_OHR;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestOrangeHR_POM extends CommonToAllTest {

    @Owner("Siddesh")
    @Description("Verify that the login to the OrangeHR")
    @Test
    public void testLoginPositive(){

      LoginPage_POM_OHR loginPagePomOhr = new LoginPage_POM_OHR(DriverManager.getDriver());
      loginPagePomOhr.loginToHRCreds(PropertiesReader.readKey("ohr_username"), PropertiesReader.readKey("ohr_password"));

        DashboardPage_POM_OHR dashboardPagePom = new DashboardPage_POM_OHR(DriverManager.getDriver());
        String loggedInUsername = dashboardPagePom.loggedInUsername();

        assertThat(loggedInUsername).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(loggedInUsername, PropertiesReader.readKey("ohr_expected_username"));

    }


}
