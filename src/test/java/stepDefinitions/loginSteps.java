package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;

public class loginSteps implements BasePage {

    @Given("App opened for the first time")
    public void userOpenedAppFirstTime() {
        LoginPage.verifyLoginScreen();
    }

    @Given("App opened after login is completed")
    public void userOpensAppAfterLogin() {
        NewsPage.validateNewsScreen();
    }

    @Then("I see Login screen with username password login button is displayed")
    public void emptyGarden() {
        LoginPage.verifyLoginScreen();
    }

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEnterUserName(String userName, String password) {
        LoginPage.enterUserNamePassword(userName, password);
    }

    @When("I click on login button")
    public void userTapOnLoginButton() {
        LoginPage.clickLoginButton();
    }

    @Then("I see error marks displayed by username and password")
    public void errorForInvalidCreds() {
        LoginPage.validateErrorForInvalidLogin();
    }

    @Then("I am taken to the news screen")
    public void UserOnNewsScreen() {
        NewsPage.validateNewsScreen();
    }

}
