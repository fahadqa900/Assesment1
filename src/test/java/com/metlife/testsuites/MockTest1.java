package com.metlife.testsuites;

import com.metlife.pageobjects.Locators;
import com.metlife.utility.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MockTest1 extends SetupTearDown
{
  WebDriver driver;
    public static WebDriverWait w1;

    public void  SearchParticipantName(String Name) throws InterruptedException
    {
        WebDriverUtils.Click1(Locators.hambergerMenu);
        //scroll(ListOfElements);
        WebDriverUtils.Click1(Locators.listOfParticipants);
        WebDriverUtils.Click1(Locators.tableContent);
        w1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        w1.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchInput));
        WebDriverUtils.type(Locators.searchInput, Name);
        List<WebElement> l1 = driver.findElement(By.xpath("//table[@id='footable_350']")).findElements(By.tagName("tr"));
        System.out.println(l1.size());
        for (int i = 1; i <= l1.size(); i++)
        {
         Thread.sleep(5000);
        //w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='footable_350']/tbody/tr[\" + i + \"]/td[2]")));
         System.out.println(driver.findElement(By.xpath("//*[@id='footable_350']/tbody/tr[" + i + "]/td[2]")).getText());
        }
    }

    public void  SearchParticipantDesignation(String Name) throws InterruptedException
    {
        WebDriverUtils.Click1(Locators.hambergerMenu);
        //scroll(ListOfElements);
        WebDriverUtils.Click1(Locators.listOfParticipants);
        WebDriverUtils.Click1(Locators.tableContent);
      //w1.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        WebDriverUtils.type(Locators.searchInput, "ch");
        List<WebElement> l2 = driver.findElement(By.xpath("//table[@id='footable_350']")).findElements(By.tagName("tr"));
        System.out.println(l2.size());
        for (int i = 1; i <= l2.size(); i++) {
         Thread.sleep(5000);
       //w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='footable_350']/tbody/tr[\" + i + \"]/td[2]")));
         System.out.println(driver.findElement(By.xpath("//*[@id='footable_350']/tbody/tr[" + i + "]/td[3]")).getText());
        }
    }
}
