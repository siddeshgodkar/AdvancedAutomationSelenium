package org.example.driver;


import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setDriver(WebDriver driver){
        DriverManager.driver = driver;
    }

    public static void init(){
        String browser = null;
        browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        if(driver == null){
            switch (browser) {
                case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.addArguments("--start-maximized");
                        edgeOptions.addArguments("--guest");
                        setDriver(new EdgeDriver(edgeOptions));
                        break;

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    setDriver(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    setDriver(new FirefoxDriver(firefoxOptions));
                    break;
                default:
                    System.out.println("Not Browser Found!");
            }
        }


    }

    public static void down(){
        if (driver !=  null){
            driver.quit();
            driver = null;
        }
    }

}
