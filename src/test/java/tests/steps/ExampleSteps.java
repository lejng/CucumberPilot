package tests.steps;

import tests.portal.api.TodoApi;
import tests.portal.entities.UserEntity;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tests.portal.pages.LoginPage;
import java.util.List;
import static io.restassured.path.json.JsonPath.from;

public class ExampleSteps {

    private LoginPage loginPage;

    public ExampleSteps(){
        loginPage = new LoginPage();
    }

    @When("I login to portal with following credentials:")
    public void login(UserEntity userEntity) {
        loginPage.login(userEntity);
    }

    @Then("The error message displayed on Login Page")
    public void checkErrorMessageDisplayed() {
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        String errorMessage = "Error: error message is not displayed on Login Page";
        Assert.assertTrue(errorMessage, isErrorMessageDisplayed);
    }

    @Then("The todo with id {string} has title {string}")
    public void checkTodoTitleById(String id, String expectedTitle) {
        String response = new TodoApi().getTodoTitle(id);
        List<String> titles = from(response).get("title");
        int expectedCount = 1;
        Assert.assertEquals("Error: Request by id return more than 1 records of todos", expectedCount, titles.size());
        String actualTitle = titles.get(0);
        String errorMessage = String.format("Error: Incorrect title for todo with id '%s'", id);
        Assert.assertEquals(errorMessage, expectedTitle, actualTitle);
    }
}
