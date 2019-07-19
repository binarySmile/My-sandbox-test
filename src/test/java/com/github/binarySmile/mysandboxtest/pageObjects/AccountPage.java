package com.github.binarySmile.mysandboxtest.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.binarySmile.mysandboxtest.BaseTest;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BaseTest {

    @FindBy(id = "login-email")
    private SelenideElement inputLoginField;

    @FindBy(id = "login-password")
    private SelenideElement inputPasswordField;

    @FindBy(xpath = "//div[5]/div/button")
    private SelenideElement enterButton;

    @FindBy(id = "login-password-error")
    private SelenideElement loginPasswordError;

    public void inputUserEmail(String email) {
        inputLoginField.click();
        inputLoginField.setValue(email);
    }

    public void inputPassword(String password) {
        inputPasswordField.click();
        inputPasswordField.setValue(password).pressEnter();
    }

    public void sendForm() {
        enterButton.click();
    }

    public SelenideElement getErrorLoginPassword() {
        return loginPasswordError.shouldHave(Condition.visible);
    }
}

