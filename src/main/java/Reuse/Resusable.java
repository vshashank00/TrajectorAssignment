package Reuse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Resusable {
    static int c = 0;
    public WebDriverWait wait;
    int a = 20;

    protected void visible(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(a));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void clickable(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    protected void dropDown(WebElement element, String state) {
        Select select = new Select(element);
        select.selectByVisibleText(state);
    }


}
