package basic;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class MultipleWindow {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given(".launch the browser")
    public void launch_the_browser() throws InterruptedException {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Windows.html");
        Thread.sleep(3000);


    }
    @When("Open the new window")
    public void open_the_new_window() throws InterruptedException {


    }
    @Then("Closing the Browser.")
    public void closing_the_browser() {
    }
}
