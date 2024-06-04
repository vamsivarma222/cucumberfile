package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeoutException;

public class GetElementAttribute {
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @Given("Navigate the element attributes")
    public void navigate_the_element_attributes() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in");
    }

    @When("Store the element in a string")
    public void store_the_element_in_a_string() {

            page.waitForSelector("//input[@placeholder='First Name']");
            String placeholderName = page.getAttribute("//input[@placeholder='First Name']", "value");
            System.out.println("Placeholder Name: " + placeholderName);
            System.out.println("Timeout or element not found");
    }

    @When("Print the data of the element")
    public void print_the_data_of_the_element() {
            page.waitForSelector("//label[normalize-space()='Cricket']");
            String checkboxType = page.locator("//label[normalize-space()='Cricket']").getAttribute("type");
            System.out.println("Checkbox Type: " + checkboxType);
            System.out.println("Timeout or element not found");
    }

    @Then("Browser Close")
    public void browser_close() {
        browser.close();
    }
}
