package com.github.binarySmile.mysandboxtest.tests;

import com.github.binarySmile.mysandboxtest.BaseTest;
import com.github.binarySmile.mysandboxtest.pageObjects.AccountPage;
import com.github.binarySmile.mysandboxtest.pageObjects.Dashboard;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;


public class AccountTest extends BaseTest {

    @Test
    public void positiveTest() {
        AccountPage accountPage = page(AccountPage.class);
        accountPage.inputUserEmail(data.getProperty("email"));
        accountPage.inputPassword(data.getProperty("password"));
        Dashboard dashboard = page(Dashboard.class);
        assertTrue(dashboard.getPageDashboard().isDisplayed());
    }

    @Test
    public void negativeTest() {
        AccountPage accountPage = page(AccountPage.class);
        accountPage.inputUserEmail(data.getProperty("email"));
        accountPage.sendForm();
        assertTrue(accountPage.getErrorLoginPassword().isDisplayed());
    }
}
