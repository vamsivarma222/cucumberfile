package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class amazon {

    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("launch the application")
    public void launch_the_application() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.amazon.com");
    }
    @When("Check the duration")
    public void check_the_duration() {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Combined duration of tasks:" + duration + "milliseconds");
    }
    @Then("close the application")
    public void close_the_application() {
        browser.close();
        page.close();
    }
}
