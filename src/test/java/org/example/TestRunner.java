package org.example;

import org.testng.TestNG;

import java.util.ArrayList;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testNG=new TestNG();
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(System.getProperty("user.dir")+"/testng.xml");
        testNG.setTestSuites(arrayList);
        testNG.run();
    }
}
