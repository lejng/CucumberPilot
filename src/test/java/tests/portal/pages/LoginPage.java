package tests.portal.pages;

import base.BaseComponent;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import tests.portal.entities.UserEntity;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BaseComponent {

    public void login(UserEntity user){
        waitForLoadScripts();
        $(By.id("index_email")).sendKeys(user.getUserName());
        $(By.id("index_pass")).sendKeys(user.getPassword());
        $(By.id("index_login_button")).click();
    }

    public boolean isErrorMessageDisplayed(){
        waitForLoadScripts();
        By locator = By.xpath("//*[@id='login_message']//div[contains(@class,'msg error')]");
        waitUntil($(locator), Condition.exist);
        return $(locator).isDisplayed();
    }
}
