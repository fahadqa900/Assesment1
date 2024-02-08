package com.metlife.testsuites;

import com.metlife.utility.WebDriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SetupTearDown
{
    @BeforeClass
    public void setup()
    {
     WebDriverUtils.initialize();
    }
    @BeforeMethod
    public void browserUrlLaunch()
    {
    WebDriverUtils.launchUrl("https://mockexam1cpsat.agiletestingalliance.org/ ");
    }

//   @AfterMethod
//    public void teardown()
//    {
//     WebDriverUtils.quitBrowser();
//    }

    @Test
    public void getName() throws InterruptedException {
        MockTest1 t1=new MockTest1();
        t1.SearchParticipantName("ch");
    }

    @Test
    public void getDesignation() throws InterruptedException {
        MockTest1 t1=new MockTest1();
        t1.SearchParticipantDesignation("ch");
    }





}