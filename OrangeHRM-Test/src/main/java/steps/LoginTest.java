package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to the dashboard")
    public void userShouldBeRedirectedToTheDashboard() {
        dashboardPage = new DashboardPage(driver);
        boolean isDashboardDisplayed = dashboardPage.isDashboardDisplayed();
        Assert.assertTrue("Dashboard is not displayed", isDashboardDisplayed);

    }

    @When("User enters invalid username {string} and password {string}")
    public void userEntersInvalidUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("User should see an error message indicating invalid username")
    public void userShouldSeeAnErrorMessageIndicatingInvalidUsername() {
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Invalid credentials"; // Adjust based on actual message
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    @When("User enters valid username {string} and invalid password {string}")
    public void userEntersValidUsernameAndInvalidPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("User should see an error message indicating invalid password")
    public void userShouldSeeAnErrorMessageIndicatingInvalidPassword() {
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Invalid credentials"; // Adjust based on actual message
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    @When("User enters blank username and valid password {string}")
    public void userEntersBlankUsernameAndValidPassword(String password) {
        loginPage.enterUsername(""); // Blank username
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("User should see an error message indicating username is required")
    public void userShouldSeeAnErrorMessageIndicatingUsernameIsRequired() {
        String actualErrorMessage = loginPage.getWarning();
        String expectedErrorMessage = "Required"; // Adjust based on actual message
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    @When("User enters valid username {string} and blank password")
    public void userEntersValidUsernameAndBlankPassword(String username) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(""); // Blank password
        loginPage.clickLoginButton();
    }

    @Then("User should see an error message indicating password is required")
    public void userShouldSeeAnErrorMessageIndicatingPasswordIsRequired() {
        String actualErrorMessage = loginPage.getWarning();
        String expectedErrorMessage = "Required"; // Adjust based on actual message
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    @When("User enters blank username and blank password")
    public void userEntersBlankUsernameAndBlankPassword() {
        loginPage.enterUsername(""); // Blank username
        loginPage.enterPassword(""); // Blank password
        loginPage.clickLoginButton();
    }

    @Then("User should see an error message indicating both fields are required")
    public void userShouldSeeAnErrorMessageIndicatingBothFieldsAreRequired() {
        String actualErrorMessage = loginPage.getWarning();
        String expectedErrorMessage = "Required"; // Adjust based on actual message
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }
}
