package com.cydeo.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class VyTrack_Utils {

    public static void login(WebDriver driver, String username, String password){
        WebElement usernameElement =driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameElement.clear();
        usernameElement.sendKeys(username);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordElement.sendKeys(password);

        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        submitBtn.click();

    }

    public static void logout(WebDriver driver){

        WebElement userMenu = driver.findElement(By.id("user-menu"));
        userMenu.click();
        WebElement logoutClick = driver.findElement(By.xpath("//a[.='Logout']"));
        logoutClick.click();

    }

   public static XSSFSheet readFromExcel(String filePath, String nameSheet){
     XSSFSheet sheet = null;

       try {
           File file= new File(filePath);
           FileInputStream inputStream = new FileInputStream(file);
           XSSFWorkbook wb = new XSSFWorkbook(inputStream);
           sheet = wb.getSheet(nameSheet);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return sheet;
   }

   public static String readUserName(XSSFRow row){
       XSSFCell cell = row.getCell(0);
       String username = cell.getStringCellValue();
       return username;
   }

   public  static String readPassword(XSSFRow row){
       XSSFCell cell = row.getCell(1);
       String password = cell.getStringCellValue();
       return password;
   }






}
