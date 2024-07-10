package org.example;

import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestRunner {
    TestNG testNG;
    @Test
    void parallel_in_oneBrowser(){
       testNG =new TestNG();
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(System.getProperty("user.dir")+"/testng.xml");
        testNG.setTestSuites(arrayList);
        testNG.run();
    }
    @Test
    void parallel_in_twoDifferentBrowser(){
        testNG=new TestNG();
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("parallel.xml");
        testNG.setTestSuites(arrayList);
        testNG.run();

    }
}
