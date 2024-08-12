package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By dashboardElement = By.xpath("//div[@id='app']");
    private By searchBox = By.xpath("//input[@placeholder='Search']"); // Arama kutusunun doğru XPath'i
    private By searchResult = By.xpath("//a[contains(@class, 'search-result')]"); // Arama sonuçlarının XPath'i
    private By adminHeader = By.xpath("//span[.='Admin']");
    private By pimHeader = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module' and text()='PIM']");
    private By leaveHeader = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module' and text()='Leave']");
    private By timeHeader = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module' and text()='Time']");
    private By recruitmentHeader = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module' and text()='Recruitment']");
    private By performanceHeader = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module' and text()='Performance']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardElement)).isDisplayed();
    }

    public void clickSearchBox() {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchInput.click();
    }

    public void enterSearchQuery(String query) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchInput.clear();
        searchInput.sendKeys(query);
    }

    public void selectSearchResult(String resultText) {
        By resultLocator = By.xpath("//a[contains(text(), '" + resultText + "')]");
        WebElement resultElement = wait.until(ExpectedConditions.elementToBeClickable(resultLocator));
        resultElement.click();
    }

    // Sayfa yüklenme kontrolleri
    public boolean isAdminPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(adminHeader)).isDisplayed();
    }

    public boolean isPIMPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pimHeader)).isDisplayed();
    }

    public boolean isLeavePageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(leaveHeader)).isDisplayed();
    }

    public boolean isTimePageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(timeHeader)).isDisplayed();
    }

    public boolean isRecruitmentPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(recruitmentHeader)).isDisplayed();
    }

    public boolean isPerformancePageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(performanceHeader)).isDisplayed();
    }
}
