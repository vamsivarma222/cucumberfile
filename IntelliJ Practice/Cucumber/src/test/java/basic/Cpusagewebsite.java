package basic;


import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cpusagewebsite {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("Open the URL in the webpage")
    public void open_the_url_in_the_webpage() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.amazon.com");
    }
    @When("Check the CPU usage")
    public void check_the_cpu_usage() {
        long startTime = System.currentTimeMillis();
        page.navigate("https://www.amazon.com");
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");


    }
    @Then("Closing the application")
    public void closing_the_application() {
        page.close();
        browser.close();

    }


}
