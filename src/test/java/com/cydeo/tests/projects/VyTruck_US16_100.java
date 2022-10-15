package com.cydeo.tests.projects;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.VyTrack_Utils;
import com.cydeo.utilities.Wait;
import org.apache.poi.xssf.usermodel.XSSFRow;
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

public class VyTruck_US16_100 extends TestBase {
    WebDriverWait wait;
    int startRow=Integer.parseInt(ConfigurationReader.getProperty("startRow"));
    int endRow=Integer.parseInt(ConfigurationReader.getProperty("endRow"));
    int startRowManager = Integer.parseInt((ConfigurationReader.getProperty("startRowManager")));

    @Test
    public void ac1_verify_users_see_three_columns_type_total_price_date() {
        driver.get(ConfigurationReader.getProperty("env"));


        for (int i = startRow; i < endRow; i++) {
            XSSFRow row = VyTrack_Utils.readFromExcel("C:\\Users\\guzel\\IdeaProjects\\MyAutomationTry\\src\\test\\java\\com\\cydeo\\Regression_Test_Data.xlsx",ConfigurationReader.getProperty("sheetName")).getRow(i);

            String username = VyTrack_Utils.readUserName(row);
            String password = VyTrack_Utils.readPassword(row);
            VyTrack_Utils.login(driver, username, password);

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
            }
            List<String> arr = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));
            Assert.assertEquals(actualHeaders, arr);

            System.out.println("actualHeaders = " + actualHeaders);

            VyTrack_Utils.logout(driver);
        }
    }

    @Test
    public void ac2_verify_users_check_the_checkbox_to_check_all_vehicle_costs() {
        driver.get(ConfigurationReader.getProperty("env"));

        for (int i = startRowManager; i < endRow; i++) {
            XSSFRow row = VyTrack_Utils.readFromExcel("C:\\Users\\guzel\\IdeaProjects\\MyAutomationTry\\src\\test\\java\\com\\cydeo\\Regression_Test_Data.xlsx",ConfigurationReader.getProperty("sheetName")).getRow(i);

            String username = VyTrack_Utils.readUserName(row);
            String password = VyTrack_Utils.readPassword(row);
            VyTrack_Utils.login(driver, username, password);

            wait = new WebDriverWait(driver, 30);
            Actions action = new Actions(driver);
            WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa-asterisk menu-icon']/..)[1]")));
            action.moveToElement(elementToHover).perform();
            WebElement elementToClick = driver.findElement(By.xpath("//span[.='Vehicle Costs']"));
            elementToClick.click();


            WebElement checkbox = driver.findElement(By.xpath("//div[@class='btn-group dropdown']//input[@type='checkbox']"));
           //not sure if i need this
            if(!checkbox.isSelected()){
                checkbox.click();
            } else {
                checkbox.click(); //to uncheck it
                checkbox.click(); //to check it again
            }

            List<WebElement> checkboxeForAllVehices = driver.findElements(By.xpath("//input[@tabindex='-1']"));

            for(WebElement eachCheckboxVehicle: checkboxeForAllVehices){
                Assert.assertTrue( eachCheckboxVehicle.isSelected());
            }

            VyTrack_Utils.logout(driver);
        }


    }
}
