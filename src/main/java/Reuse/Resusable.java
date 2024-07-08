package Reuse;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;


public class Resusable {
    static int c = 0;
    public WebDriverWait wait;
    int a = 20;

    //Logging the Steps
    protected static void log(String message) {
        System.out.println(message);
        try (FileWriter logFile = new FileWriter("test_log.log", true)) {
            logFile.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void visible(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(a));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void clickable(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    protected void dropDown(WebElement element, String state) {
        Select select = new Select(element);
        select.selectByVisibleText(state);
    }

    //Resizing the window
    protected void resizeWindow(int x, int y, WebDriver driver) {
        driver.manage().window().setSize(new Dimension(x, y));
        log("Window is resized to mobile size");
    }
    protected void scroll(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


}
