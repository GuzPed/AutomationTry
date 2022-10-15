package com.cydeo.tests.automation_exercise;

import com.cydeo.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 extends TestBase {

    @Test
    public void test1() {

        driver.get("http://automationexercise.com");
        Faker faker = new Faker();

        // 4. Click on 'Signup / Login' button
        WebElement signLogin = driver.findElement(By.xpath("//a[@href='/login']"));
        signLogin.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newSignText = driver.findElement(By.xpath("//div[@class='signup-form']/h2"));
        String newSignText2 = newSignText.getText();

        Assert.assertEquals(newSignText2, "New User Signup!");

       // 6. Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(faker.name().username());
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("moscow.chelny@gmail.com");

        //7. Click 'Signup' button
        WebElement singUpBtn = driver.findElement(By.xpath("//button[.='Signup']"));
        singUpBtn.click();

        //Fill details: Title, Name, Email, Password, Date of birth
        WebElement radioBtn = driver.findElement(By.id("id_gender2"));
        radioBtn.click();
        radioBtn.isSelected();

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Mama-1234");

        Select selectDropDown1 = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        selectDropDown1.selectByValue("1");

        Select selectDropDown2 = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        selectDropDown2.selectByVisibleText("March");

        Select selectDropDown3 = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectDropDown3.selectByValue("1989");

        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkboxNewsletter = driver.findElement(By.xpath("//input[@id='newsletter']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkboxNewsletter);


        // Select checkbox 'Receive special offers from our partners!'
        WebElement checkBoxSpecialOffer = driver.findElement(By.xpath("//input[@id='optin']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBoxSpecialOffer);



        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement fistName = driver.findElement(By.xpath("//input[@id='first_name']"));
        fistName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys(faker.name().lastName());

        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().streetAddress());

        Select dropdownCountry = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        dropdownCountry.selectByVisibleText("United States");

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());

//13. Click 'Create Account button'
        WebElement singInBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", singInBtn);

        WebElement continueBtn = driver.findElement(By.linkText("Continue"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);

        WebElement deleteBtn = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);

        WebElement deleteApp = driver.findElement(By.xpath("//button[.='Delete']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteApp);






    }
}
