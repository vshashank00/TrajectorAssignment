package org.example;

import Reuse.Resusable;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Trajector_Medical_Home_Page_Mob extends Resusable {
    Trajector_Medical_Home_Page_Mob(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    WebDriver driver;
    @FindBy(xpath = "//div[@data-id='6a2c8967']")
    WebElement evaluation;
    @FindBy(css = "div[class*='elementor-element-4031a3d5 e-flex e-con-boxed e-con e-parent']")
    WebElement form;

    //Verify that the driver is on expected page
    Faker faker=new Faker();
    private void verifyPage() {
        resizeWindow(375, 812, driver);
        log("Mob view enabled");
        Assert.assertEquals(driver.getTitle(), "Medical Evidence To Support Your Disability Claim - Trajector Medical");
        log("Landed on => " + driver.getCurrentUrl());
    }

    //This method fills out the form
    public void fillForm() {
        visible(evaluation, driver);
        evaluation.click();
        log("Clicked on " + evaluation.getText() + " button");
        visible(form, driver);
        Trajector_Medical_Home_Page trajectorMedicalHomePage=new Trajector_Medical_Home_Page(driver);
        trajectorMedicalHomePage.details();

    }

    //calling all the methods in one method
    public void pageValidations() {
        verifyPage();
        fillForm();

    }

}

