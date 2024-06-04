package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.file.Paths;

public class CaptureScreenshot {
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @Given("Launch browser")
    public void launch_browser() {
       Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in");

    }
    @When("Capture the screenshort")
    public void capture_the_screenshort() {
        page.locator( "//img[@id='logo']").screenshot (new Locator.ScreenshotOptions()
                .setPath(Paths.get("Screenshort/logo.png")));
    }
    @Then("close application")
    public void close_application() {
        page.close();
        browser.close();

    }

}
