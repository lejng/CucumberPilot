package tests.steps;

import tests.portal.api.TodoApi;
import tests.portal.entities.UserEntity;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tests.portal.pages.LoginPage;

public class ExampleSteps {

    private LoginPage loginPage;

    public ExampleSteps(){
        LoginPage loginPage = new LoginPage();
    }

    @When("I login to portal with following credentials:")
    public void login(UserEntity userEntity) {
        loginPage.login(userEntity);
    }

    @Then("The error message displayed on Login Page")
    public void checkErrorMessageDisplayed() {
        boolean isUserLogged = loginPage.isErrorMessageDisplayed();
        String errorMessage = "Error: error message is not displayed on Login Page";
        Assert.assertTrue(errorMessage, isUserLogged);
    }

    @Then("The todo with id {string} has title {string}")
    public void checkTodoTitleById(String id, String expectedTitle) {
        String actualTitle = new TodoApi().getTodoTitle(id);
        String errorMessage = String.format("Error: Incorrect title for todo with id '%s'", id);
        Assert.assertEquals(errorMessage, expectedTitle, actualTitle);
    }
}
