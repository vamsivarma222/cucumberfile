package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HandleDropdowns {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private Playwright playwright;

    @Given("Open automation demosite")
    public void open_automation_demosite() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");
    }
    @When("Select the Dropdown")
    public void select_the_dropdown() {
        page.selectOption("//select[@id='Skills']","C");
        page.selectOption("//select[@id='yearbox']","1919");
    }
    @Then("Shutdown the browser")
    public void shutdown_the_browser() {
        page.close();
        browser.close();


    }
}
