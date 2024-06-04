package basic;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MouseHover {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("Launch  browser")
    public void launch_browser() {
        Playwright playwright =Playwright.create();
        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/hovers");
    }
    @When("To Perform Mouse Hover action")
    public void to_perform_mouse_hover_action() {

        page.hover("//div[@class='example']//div[1]//img[1]");
    }
    @Then("Close the  browser")
    public void close_the_browser() {
        page.close();
        browser.close();
    }

}
