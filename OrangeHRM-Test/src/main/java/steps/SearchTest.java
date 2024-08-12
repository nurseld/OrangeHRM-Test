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

public class SearchTest {

    private WebDriver driver;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    @Given("User is logged in and on the Dashboard page")
    public void userIsLoggedInAndOnTheDashboardPage() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        dashboardPage = new DashboardPage(driver);
        boolean isDashboardDisplayed = dashboardPage.isDashboardDisplayed();
        Assert.assertTrue("Dashboard is not displayed", isDashboardDisplayed);
    }

    @When("User clicks on the search box")
    public void userClicksOnTheSearchBox() {
        dashboardPage.clickSearchBox();
    }

    @And("User enters {string} in the search box")
    public void userEntersInTheSearchBox(String query) {
        dashboardPage.enterSearchQuery(query);
    }

    @And("User clicks on the {string} search result")
    public void userClicksOnTheSearchResult(String resultText) {
        dashboardPage.selectSearchResult(resultText);
    }

    @Then("User should be navigated to the {string} page")
    public void userShouldBeNavigatedToThePage(String page) {
        switch (page) {
            case "Admin":
                Assert.assertTrue("Admin page is not displayed", dashboardPage.isAdminPageLoaded());
                break;
            case "PIM":
                Assert.assertTrue("PIM page is not displayed", dashboardPage.isPIMPageLoaded());
                break;
            case "Leave":
                Assert.assertTrue("Leave page is not displayed", dashboardPage.isLeavePageLoaded());
                break;
            case "Time":
                Assert.assertTrue("Time page is not displayed", dashboardPage.isTimePageLoaded());
                break;
            case "Recruitment":
                Assert.assertTrue("Recruitment page is not displayed", dashboardPage.isRecruitmentPageLoaded());
                break;
            case "Performance":
                Assert.assertTrue("Performance page is not displayed", dashboardPage.isPerformancePageLoaded());
                break;
            default:
                Assert.fail("Unknown page: " + page);
        }
    }

}
