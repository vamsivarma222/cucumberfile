package basic;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MouseRightClick {
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @Given("Launching a website")
    public void launching_a_website() {
        Playwright playwright=Playwright.create();
        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context= browser.newContext();
        page= context.newPage();
        page.navigate("https://dev.automationtesting.in/table");


    }
    @When("Performing right click operation")
    public void performing_right_click_operation() {
        Object MouseButton;
        page.locator("//tbody/tr[1]/td[2]")
                .click(new Locator.ClickOptions().setButton(com.microsoft.playwright.options.MouseButton.RIGHT));
    }
    @Then("Closing  Browser")
    public void closing_browser() {
page.close();
browser.close();

    }


}
