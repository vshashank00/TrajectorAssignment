package org.example;


import org.testng.annotations.Test;

public class Trajector_Medical_Full_View extends BaseTest {

    @Test(enabled = true)
    void test1() {
        Trajector_Medical_Home_Page trajectorMedicalHomePage = new Trajector_Medical_Home_Page(driver);
        trajectorMedicalHomePage.pageValidations();
    }

}
