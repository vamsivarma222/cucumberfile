package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HandlingTestboxes {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("Launch the browserlink")
    public void launch_the_browserlink() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.integrate.io/demo/");

    }
    @When("Added the test in the checkboxes")
    public void added_the_test_in_the_checkboxes() throws InterruptedException {
        page.type("//div[@class='form-container ']","vamsivarma");
        page.type("//input[@id='lastname-01ce80b6-0fd9-45be-8431-abad8d0036bf']","varma");

       Thread.sleep(3000);
    }
    @Then("After that Close the Browser")
    public void after_that_close_the_browser() {
        page.close();
        browser.close();


    }

}
