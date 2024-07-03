package org.example;


import org.testng.annotations.Test;

public class Trajector_Medical_Smoke_Suite extends BaseTest {
    @Test
    void Test1() {
        Trajector_Medical_Home_Page trajectorMedicalHomePage = new Trajector_Medical_Home_Page(driver);
        trajectorMedicalHomePage.pageValidations();
    }
}
