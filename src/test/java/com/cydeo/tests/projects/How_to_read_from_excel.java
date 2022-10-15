package com.cydeo.tests.projects;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class How_to_read_from_excel {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\guzel\\IdeaProjects\\MyAutomationTry\\src\\ac1_verify_users_see_three_columns_type_total_price_date\\java\\com\\cydeo\\Regression_Test_Data.xlsx");
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("crm");
        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(0);
        String username = cell.getStringCellValue();
        System.out.println(username);

        cell = row.getCell(1);
        String password = cell.getStringCellValue();
        System.out.println(password);


    }




}
