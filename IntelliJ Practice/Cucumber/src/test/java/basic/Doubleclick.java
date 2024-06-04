package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Doubleclick {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("Open the website")
    public void open_the_website() {
        Playwright playwrtight = Playwright.create();
        browser=playwrtight.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context=browser.newContext();
        page= context.newPage();
        page.navigate("https://demo.automationtesting.in/Alerts.html");

    }
    @When("Perform mouse doubleclick operation")
    public void perform_mouse_doubleclick_operation() {

        page.dblclick("//body");
    }
    @Then("Close Browser..")
    public void close_browser() {
        page.close();
        browser.close();
    }
}
