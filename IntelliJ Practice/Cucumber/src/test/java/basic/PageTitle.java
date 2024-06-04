package basic;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
public class PageTitle {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("Launch the browser")
    public void launch_the_browser() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.amazon.com");
    }
    @When("Check the title")
    public void check_the_title()
    {

        assertEquals("Amazon.com",page.title());
    }
    @Then("Close the Browser")
    public void close_the_browser() {
    page.close();
    browser.close();
    }
}
