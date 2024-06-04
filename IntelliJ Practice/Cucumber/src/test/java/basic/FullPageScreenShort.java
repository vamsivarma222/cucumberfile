package basic;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.nio.file.Paths;
public class FullPageScreenShort {
private Page page;
private BrowserContext context;
private Browser browser;
    @Given("Open the browser")
    public void open_the_browser() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in");
    }
    @When("Take Fullscreenshort")
    public void take_fullscreenshort() {

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshort/logo1.png")).setFullPage(true));

    }
    @Then("{string}")
    public void string(String string) {
        page.close();
        browser.close();
    }
}
