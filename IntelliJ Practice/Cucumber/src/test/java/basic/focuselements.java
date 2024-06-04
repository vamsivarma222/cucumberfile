package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class focuselements {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private Playwright playwright;

    @Given("Lanuch the browser ..")
    public void lanuch_the_browser() throws InterruptedException {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");
        Thread.sleep(5000);
    }
    @When("focus on the particular element")
    public void focus_on_the_particular_element() throws InterruptedException {
        page.focus("//textarea[@class='form-control ng-pristine ng-valid ng-touched']");
        Thread.sleep(5000);
        page.focus("//input[@type='email']");
        Thread.sleep(5000);

    }
    @Then("Closing the application after focing the element")
    public void closing_the_application_after_focing_the_element() {
    browser.close();
     page.close();
    }
}
