package basic;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class MultipleTabs {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("launching the browser")
    public void launching_the_browser() throws InterruptedException {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Windows.html");
        Thread.sleep(3000);
    }
    @When("Open the new tab")
    public void open_the_new_tab() throws InterruptedException {
        page.click("//a[normalize-space()='Open New Tabbed Windows']\n");
        Thread.sleep(3000);
        page.click("//a[@href='http://www.selenium.dev']//button[@class='btn btn-info'][normalize-space()='click']");
        Thread.sleep(3000);
    }
    @Then("Closing the Browser")
    public void closing_the_browser() {
    page.close();
    browser.close();
    }
}
