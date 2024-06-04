package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KeyboadActions {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("Launching browser")
    public void launching_browser() {
        Playwright playwright = Playwright.create();
        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext();
        page= context.newPage();
        page.navigate("https://the-internet.herokuapp.com/key_presses");
    }
    @When("To Perform these actions enter space and tab button")
    public void to_perform_these_actions_enter_space_and_tab_button() throws InterruptedException {
        page.press("//input[@id='target']","Enter");
        Thread.sleep(3000);
        page.press("//input[@id='target']","Space");
        Thread.sleep(3000);
        page.press("//input[@id='target']","Tab");
        Thread.sleep(3000);
    }
    @When("To perform copy page and")
    public void to_perform_copy_page_and() throws InterruptedException {
        page.navigate("https://demo.automationtesting.in/Register.html");
        page.fill("//input[@placeholder='First Name']","vamsivarma");
        page.press("//input[@placeholder='First Name']","Control+A");
        Thread.sleep(3000);
        page.press("//input[@placeholder='First Name']","Control+C");
        Thread.sleep(3000);
        page.press("//input[@placeholder='Last Name']","Control+V");
        Thread.sleep(3000);
    }
    @Then("Close browser")
    public void close_browser() {
    }
}
