package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;

public class newsSteps implements BasePage {


    @Given("^User successfully logged in to the app and \"([^\"]*)\" connection$")
    public void userSuccessfullyLoggedIn(String type) throws Exception {
        LoginPage.toggleTheNetwork(type);
        LoginPage.loggedInSuccessfully();

    }

    @Then("I see images displayed in the rows on the list and scrollable horizontally")
    public void imagesLoadedAsListAndScrollable() throws InterruptedException {
        NewsPage.validateAndScrollImagesHorizontally();
    }

    @Then("I see failed lo load news error message displayed with retry button")
    public void newsScreenWhenNoInternet() {
        NewsPage.validateErrorMessageOnNewsScreen();
    }

    @When("News images are successfully loaded on the screen")
    public void newsImagesLoaded() throws InterruptedException {
        NewsPage.validateAndScrollImagesHorizontally();
    }

    @When("I click on the news image")
    public void tapOnNewsImage() {
        NewsPage.tapOnNewsImage();
    }
    @Then("I am navigated to the external browser with clicked image loaded")
    public void userNavigatedToExternalBrowser() {
        NewsPage.validateURLOpened();
    }

}
