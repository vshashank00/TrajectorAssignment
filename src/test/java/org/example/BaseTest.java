package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;

    String url="https://www.trajectormedical.com/";
    WebDriver driverInitialize(String broweser) throws IOException {
        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/BrowserProperties/Browser.properties");
        properties.load(fileInputStream);
        if(broweser.isEmpty())
         broweser=System.getProperty("browser")!=null?System.getProperty("browser"):properties.getProperty("Browser");
        if (broweser.contains("chrome")){
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("disable-notifications");
            chromeOptions.setAcceptInsecureCerts(true);
            if(broweser.contains("headless")){
                chromeOptions.addArguments("headless");
            }
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver(chromeOptions);
            if(broweser.contains("headless")){driver.manage().window().setSize(new Dimension(1440,900));
            }
        }else if(broweser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.addArguments("disable-notification");
            driver=new FirefoxDriver(firefoxOptions);
        } else if (broweser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions=new EdgeOptions();
            edgeOptions.addArguments("--disable-features=msHubApps");
            driver=new EdgeDriver(edgeOptions);
        }else
            System.out.println("driver config is not setup");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    void setupBrowser(@Optional("")String broweser) throws IOException {
        driver=driverInitialize(broweser);
        driver.get(url);
    }
    @AfterMethod
    void close(){
        driver.quit();
    }
}
