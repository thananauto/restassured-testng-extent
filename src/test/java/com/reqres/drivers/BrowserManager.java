package com.reqres.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserManager {
    public static WebDriver doBrowserSetup(String browserName) throws MalformedURLException {

        WebDriver driver = null;
        DesiredCapabilities capabilities = null;
        if (browserName.equalsIgnoreCase("chrome")){
            //steup chrome browser
            WebDriverManager.chromedriver().setup();
            //Add options for --headed or --headless browser launch
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("-headed");
            chromeOptions.addArguments("--remote-allow-origins=*");
            //initialize driver for chrome
           // driver = new ChromeDriver(chromeOptions);
             capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");

        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();

           // driver = new FirefoxDriver();
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "firefox");
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
       //maximize window
            driver.manage().window().maximize();

            //add implicit timeout
            driver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(30));


        return driver;
    }
}
