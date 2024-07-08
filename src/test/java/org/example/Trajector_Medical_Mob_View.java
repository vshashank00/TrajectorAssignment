package org.example;

import org.testng.annotations.Test;

public class Trajector_Medical_Mob_View extends BaseTest{
    @Test(enabled = true)
    void test1(){
        Trajector_Medical_Home_Page_Mob trajectorMedicalHomePageMob=new Trajector_Medical_Home_Page_Mob(driver);
        trajectorMedicalHomePageMob.pageValidations();

    }
}
