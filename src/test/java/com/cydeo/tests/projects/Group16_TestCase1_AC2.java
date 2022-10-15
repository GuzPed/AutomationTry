package com.cydeo.tests.projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Group16_TestCase1_AC2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://login1.nextbasecrm.com/");

     //   List<String> login = new ArrayList<>(Arrays.asList("hr46@Cydeo.com", "hr47@cydeo.com", "hr48@cydeo.com", "helpdesk46@cydeo.com", "helpdesk47@cydeo.com", "helpdesk48@cydeo.com", "marketing46@cydeo.com", "marketing47@cydeo.com", "marketing48@cydeo.com"));
       String expectedErrorMessage = "Incorrect username or password";

        Map<String, String> credentials= new HashMap<>(Map.of("hr46@cydeo.com", "USERUSER", "helpdesk47@cydeo.com", "useruser", "marketing4666@CYDEO.com", "UserUser"));

        for(Map.Entry<String, String> eachEntry: credentials.entrySet()){

            //finds login input and paste the value
            WebElement loginInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            //clears the login input, because after loging out, the value stays from previous step
            loginInput.clear();
            loginInput.sendKeys(eachEntry.getKey());

            //finds password input and paste the value
            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            passwordInput.sendKeys(eachEntry.getValue());

            //find login button and clicks it
            WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
            loginButton.click();

            String actualErrorText = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
            System.out.println(actualErrorText);
            System.out.println(expectedErrorMessage);

            if(actualErrorText.equals(expectedErrorMessage)){
                System.out.println("Username " + eachEntry.getValue() + ", password " + eachEntry.getValue() + ". INVALID login verification passed");
            } else {
                System.out.println("Username " + eachEntry.getValue() + ", password " + eachEntry.getValue() + ". INVALID login verification FAILED");
            }


            //refreshes page (login page)
            driver.get("https://login1.nextbasecrm.com/");

        }


        driver.quit();


    }
}
