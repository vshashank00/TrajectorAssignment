package org.example;

import Reuse.Resusable;
import com.github.javafaker.Faker;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class Trajector_Medical_Home_Page extends Resusable {
    private static final Faker faker = new Faker();
    WebDriver driver;
    @FindBy(xpath = "//span[contains(text(),'FREE Medical Evaluation')]/ancestor::div[contains(@class,'elementor-align-right elementor-widget elementor-widget-button')]")
    WebElement evaluation;
    @FindBy(css = "div[class='elementor-element elementor-element-4031a3d5 e-flex e-con-boxed e-con e-parent']")
    WebElement form;
    @FindBy(css = "#input_33_1_3")
    WebElement firstNameField;
    @FindBy(css = "#input_33_1_6")
    WebElement lastNameField;
    @FindBy(css = "#input_33_5")
    WebElement emailField;
    @FindBy(css = "#input_33_13")
    WebElement phoneField;
    @FindBy(css = "#choice_33_6_0")
    WebElement vetranRadioButton;
    @FindBy(css = "#choice_33_7_0")
    WebElement disabilityRadioButton;
    @FindBy(css = "#choice_33_10_1")
    WebElement workedYearsRadioButton;
    @FindBy(css = "#input_33_14_4")
    WebElement stateField;
    @FindBy(css = "#input_33_14_5")
    WebElement zipCodeField;
    Trajector_Medical_Home_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


//Verify that the driver is on expected page
    private void verifyPage() {
        Assert.assertEquals(driver.getTitle(), "Medical Evidence To Support Your Disability Claim - Trajector Medical");
        log("landed on "+driver.getCurrentUrl());
    }
//This method fills out the form
  private void fillForm() {
        visible(evaluation, driver);
        evaluation.click();
        log("Clicked on "+evaluation.getText()+" button");
        visible(form, driver);
        details();


    }
//using Faker class for genrating data
   private void details() {
        firstNameField.sendKeys(faker.name().firstName());
        lastNameField.sendKeys(faker.name().lastName());
        emailField.sendKeys(faker.internet().emailAddress());
        phoneField.sendKeys(faker.phoneNumber().cellPhone());
        clickable(vetranRadioButton, driver);
        vetranRadioButton.click();
        Assert.assertTrue(vetranRadioButton.isSelected());
        clickable(disabilityRadioButton, driver);
        disabilityRadioButton.click();
        Assert.assertTrue(disabilityRadioButton.isSelected());
        clickable(workedYearsRadioButton, driver);
        workedYearsRadioButton.click();
        Assert.assertTrue(workedYearsRadioButton.isSelected());
        dropDown(stateField, faker.address().state());
        zipCodeField.sendKeys(faker.address().zipCode());
        log("Form is filled with random data");

    }
    //Resizing the window
    private void resizeWindow(int x,int y){
        driver.manage().window().setSize(new Dimension(x,y));
        log("Window is resized to mobile size");
    }
    //Logging the Steps
    private static void log(String message) {
        System.out.println(message);
        try (FileWriter logFile = new FileWriter("test_log.log", true)) {
            logFile.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //calling all the methods in method
    public void pageValidations(){
        verifyPage();
        fillForm();
        resizeWindow(375,812);
    }
}
