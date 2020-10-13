package tests.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import utils.PropertyHelper;
import static com.codeborne.selenide.Selenide.open;

public class CommonHooks {

    @Before(value = "@ui")
    public void setUp(){
        Configuration.browser = PropertyHelper.getBrowserName();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        open(PropertyHelper.getBaseUrl());
    }

    @After(value = "@ui")
    public void tearDown(){
        WebDriverRunner.closeWebDriver();
    }
}
