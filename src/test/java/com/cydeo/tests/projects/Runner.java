package com.cydeo.tests.projects;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.VyTrack_Utils;
import com.cydeo.utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner extends TestBase {
    WebDriverWait wait;

    @Test
    public void runner1(){
        driver.get(ConfigurationReader.getProperty("env"));

        VyTrack_Utils.login(driver, ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        wait = new WebDriverWait(driver, 30);
        Actions action = new Actions(driver);
        WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa-asterisk menu-icon']/..)[1]")));
        action.moveToElement(elementToHover).perform();
        WebElement elementToClick = driver.findElement(By.xpath("//span[.='Vehicle Costs']"));
        elementToClick.click();

        Wait.sleep(2);
        List<WebElement> headersOfTable = driver.findElements(By.xpath("//thead[@class='grid-header']//span[@class='grid-header-cell__label']"));

        List<String> actualHeaders = new ArrayList<>();
        for (WebElement each: headersOfTable) {
            actualHeaders.add(each.getText());
            System.out.println("each.getText() = " + each.getText());
        }
        List<String> arr = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));
        System.out.println("actualHeaders = " + actualHeaders);

    }
    @Test
    public void runner2() {
        driver.get(ConfigurationReader.getProperty("env"));

        VyTrack_Utils.login(driver, ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        wait = new WebDriverWait(driver, 30);
        Actions action = new Actions(driver);
        WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa-asterisk menu-icon']/..)[1]")));
        action.moveToElement(elementToHover).perform();
        WebElement elementToClick = driver.findElement(By.xpath("//span[.='Vehicle Costs']"));
        elementToClick.click();


        WebElement checkbox = driver.findElement(By.xpath("//div[@class='btn-group dropdown']//input[@type='checkbox']"));
            if(!checkbox.isSelected()){
                checkbox.click();
            } else {
                checkbox.click();
                checkbox.click();
            }

            List<WebElement> checkboxeForAllVehices = driver.findElements(By.xpath("//input[@tabindex='-1']"));

            for(WebElement eachCheckboxVehicle: checkboxeForAllVehices){
                Assert.assertTrue( eachCheckboxVehicle.isSelected());
            }

            VyTrack_Utils.logout(driver);
        }
}
