package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //create private constractor, so we are closing the access to the object of this class
    //from outside code
    private Driver(){}

    //making our 'driver' instanve private, so that it is not reachable from outside the class
    //we are making it static, so we want it to run before anything else
    //also we will use it in static method
    private static WebDriver driver;

    //creae reusable utility method which will return same driver instance when we call it
    public static WebDriver getDriver(){
        if(driver==null){
            String browser = ConfigurationReader.getProperty("browser");

            //depending on the browserType our switch statement will determine to open specific type of browser/driver
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }

        }
        //same driver instance will be returned every time we call Driver.getDriver() method
        return driver;
    }


}
