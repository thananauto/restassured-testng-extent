package com.reqres.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserManager {
    public static WebDriver doBrowserSetup(String browserName){

        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")){
            //steup chrome browser
            WebDriverManager.chromedriver().setup();


            //Add options for --headed or --headless browser launch
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("-headed");
            chromeOptions.addArguments("--remote-allow-origins=*");

            //initialize driver for chrome
            driver = new ChromeDriver(chromeOptions);

            //maximize window
            driver.manage().window().maximize();

            //add implicit timeout
            driver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(30));

        }
        return driver;
    }
}
