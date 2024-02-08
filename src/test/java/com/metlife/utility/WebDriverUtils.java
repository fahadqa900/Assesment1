package com.metlife.utility;

import com.metlife.pageobjects.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class WebDriverUtils
{
    static WebDriver driver;
    static WebDriverWait w1;

    public static void initialize()
    {
        switch (PropertyUtils.getProperty("browser"))
        {
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void quitBrowser()
    {
        driver.quit();
    }

    public static void launchUrl(String url)
    {
        driver.get(url);
    }

    public static void type(By locator, String value)
    {
     WebElement ele=driver.findElement(locator);
     ele.clear();
     ele.sendKeys(value);
    }

    public static void Click1(By locator)
    {
     driver.findElement(locator).click();
    }

    public static void scroll()
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,1200)");
    }

    public static void getParticipantName(String name)
    {
       try
       {
        WebDriverUtils.type(Locators.searchInput, name);
       }
        catch (Exception e)
        {
            w1 = new WebDriverWait(driver, Duration.ofSeconds(30));
            w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
            WebDriverUtils.type(Locators.searchInput, name);
        }
    }
}

