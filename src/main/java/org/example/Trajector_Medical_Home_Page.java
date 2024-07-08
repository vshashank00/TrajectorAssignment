package org.example;

import Reuse.Resusable;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Trajector_Medical_Home_Page extends Resusable {
    Trajector_Medical_Home_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    private static final Faker faker = new Faker();
    WebDriver driver;
    @FindBy(xpath = "//div[@data-id='25d83513']")
    WebElement evaluation;
    @FindBy(css = "div[class*='elementor-element-4031a3d5 e-flex e-con-boxed e-con e-parent']")
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
    //Verify that the driver is on expected page
    protected void verifyPage() {
        Assert.assertEquals(driver.getTitle(), "Medical Evidence To Support Your Disability Claim - Trajector Medical");
        log("Landed on => " + driver.getCurrentUrl());
    }

    //This method fills out the form
    public void fillForm() {
        visible(evaluation, driver);
        evaluation.click();
        log("Clicked on " + evaluation.getText() + " button");
        visible(form, driver);
        details();
    }

    //using Faker class for genrating data
    protected void details() {
        firstNameField.sendKeys(faker.name().firstName());
        lastNameField.sendKeys(faker.name().lastName());
        emailField.sendKeys(faker.internet().emailAddress());
        phoneField.sendKeys(faker.phoneNumber().cellPhone());
        clickable(vetranRadioButton, driver);
        scroll(driver,emailField);
        vetranRadioButton.click();
        Assert.assertTrue(vetranRadioButton.isSelected());
        clickable(disabilityRadioButton, driver);
        disabilityRadioButton.click();
        Assert.assertTrue(disabilityRadioButton.isSelected());
        workedYearsRadioButton.click();
        Assert.assertTrue(workedYearsRadioButton.isSelected());
        dropDown(stateField, faker.address().state());
        zipCodeField.sendKeys(faker.address().zipCode());
        log("Form is filled with random data");

    }

    //calling all the methods in one method
    public void pageValidations() {
        verifyPage();
        fillForm();
    }
}
