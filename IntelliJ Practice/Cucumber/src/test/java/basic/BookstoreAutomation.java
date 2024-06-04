package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookstoreAutomation {
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @Given("Open the bookstore website")
    public void open_the_bookstore_website() {
        Playwright playwright=Playwright.create();
        browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page= context.newPage();
        page.navigate("https://automationbookstore.dev/");

    }
    @When("Search a particular book")
    public void search_a_particular_book() {
        page.fill("//input[@id='searchBar']","test automation in the real world");
        page.click("//h2[@id='pid1_title']");

    }
    @Then("After that Close the browser")
    public void after_that_close_the_browser() {
        page.close();
        browser.close();
    }


}
