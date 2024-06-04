package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HandleFrame {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("Open the browserlink")
    public void open_the_browserlink() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Frames.html");
    }
    @When("Enter the data in the inner frame")
    public void enter_the_data_in_the_inner_frame() {
        page.frameLocator("//iframe[@id='singleframe']")
                .locator("//input[@type='text']").fill("single fame");
    }
    @Then("Close the browser.")
    public void close_the_browser() {
        page.close();
        browser.close();
    }
}
