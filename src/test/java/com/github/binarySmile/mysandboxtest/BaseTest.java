package com.github.binarySmile.mysandboxtest;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected static final String URL = "https://my.maxpay.com/#/signin";
    protected static Properties data;

    protected BaseTest(){
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeTest
    public void initialize(){
        data = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                    + "/src/test/resources/data.properties")){
                data.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void init(){
        open(URL);
    }

    @AfterTest
    public void dispose(){
        close();
    }
}
