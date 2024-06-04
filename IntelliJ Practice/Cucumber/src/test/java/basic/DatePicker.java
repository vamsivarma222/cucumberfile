package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatePicker {
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @Given("Open the website-{int}")
    public void open_the_website(Integer int1) {
        Playwright playwright = Playwright.create();
        browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Datepicker.html");
    }
    @When("Select Particular date")
    public void select_particular_date() throws InterruptedException {
        page.locator("//input[@id='datepicker2']").fill("01/04/2024");
        page.keyboard().press("Enter");
        Thread.sleep(50000);
    }
    @Then("To Close the browsr")
    public void to_close_the_browsr() {
        page.close();
        browser.close();

    }

}
