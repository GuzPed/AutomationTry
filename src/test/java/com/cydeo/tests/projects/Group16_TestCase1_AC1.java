package com.cydeo.tests.projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Group16_TestCase1_AC1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://login1.nextbasecrm.com/");

        List<String> login = new ArrayList<>(Arrays.asList("hr46@cydeo.com", "hr47@cydeo.com", "hr48@cydeo.com", "helpdesk46@cydeo.com", "helpdesk47@cydeo.com", "helpdesk48@cydeo.com", "marketing46@cydeo.com", "marketing47@cydeo.com", "marketing48@cydeo.com"));
        String password = "UserUser";

        String expextedTitle = "Portal";


        for(int i=0; i< login.size(); i++){

            //finds login input and paste the value
            WebElement loginInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            //clears the login input, because after loging out, the value stays from previous step
            loginInput.clear();
            loginInput.sendKeys(login.get(i));

            //finds password input and paste the value
            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            passwordInput.sendKeys(password);

            //find login button and clicks it
            WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
            loginButton.click();

            //gets the actual title of the page
            String actualTitle = driver.getTitle();

            //checks if it logged in or not
            if (actualTitle.equals(expextedTitle)){
                System.out.println("Username " + login.get(i) + ", password " + password + " login verification passed");
            } else {
                System.out.println("Username " + login.get(i) + ", password " + password + " login verification FAILED");
            }

            //find the profile button of options to logout
            WebElement profileButton = driver.findElement(By.xpath("//div[@id='user-block']"));
            profileButton.click();

            //finds log out button and clicks it
            WebElement logoutButton = driver.findElement(By.xpath("//a[@class='menu-popup-item menu-popup-no-icon '][3]/span[2]"));
            logoutButton.click();

            //refreshes page (login page)
            driver.navigate().refresh();

           //loginInput.clear();


        }


        driver.quit();

    }

}
