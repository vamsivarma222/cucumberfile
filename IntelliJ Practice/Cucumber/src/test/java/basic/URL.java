package basic;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class URL {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    
    @Given("Open link of the browser")
    public void open_link_of_the_browser() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Windows.html");
    }
    @When("Print the URL")
    public void print_the_url() {
        String PageURL = page.url();
        System.out.println("Print the URL:" + PageURL );
    }
    @Then("Closing the Browser ..")
    public void closing_the_browser() {
 page.close();
 browser.close();
    }
}
