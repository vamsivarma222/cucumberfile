package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PageContent {
    private Page page;
    private Browser browser;
    @Given("launch the browser")
    public void launch_the_browser() {
        Playwright playwright = Playwright.create();
        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        BrowserContext context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/");

    }
    @When("print the page context")
    public void print_the_page_context() {
        BrowserContext pagecontent = page.context();
        System.out.println(pagecontent);

    }
    @Then("Close the browser")
    public void close_the_browser() {
        page.close();
        browser.close();

    }

}
