package com.github.binarySmile.mysandboxtest.pageObjects;

import com.codeborne.selenide.SelenideElement;
import com.github.binarySmile.mysandboxtest.BaseTest;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class Dashboard extends BaseTest {

    @FindBy(id = "page-container")
    private SelenideElement pageDashboard;

    public SelenideElement getPageDashboard() {
        return pageDashboard.shouldBe(visible);
    }
}
