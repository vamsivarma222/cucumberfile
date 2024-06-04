package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckRadioButtons {
    private Browser browser;
    private Page page;
    private BrowserContext context;

    @Given("Browser launch")
    public void browser_launch() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");

    }
    @When("Select the Check box")
    public void select_the_check_box() throws InterruptedException {
        page.check("//input[@value='Male']");
        Thread.sleep(5000);


    }
    @When("Unselect the Check box")
    public void unselect_the_check_box() throws InterruptedException {
        page.check("//input[@value='Male']");
        Thread.sleep(5000);
        page.check("//input[@id='checkbox1']");
        Thread.sleep(2000);
        page.uncheck("//input[@id='checkbox1']");
        Thread.sleep(2000);
    }
    @Then("Browser Closing")
    public void browser_closing() {
        page.close();
        browser.close();

    }

}
