package basic;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MouseLeftclickOption {
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @Given("Launch the  browser")
    public void launch_the_browser() {
        Playwright playwright = Playwright.create();
        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context=browser.newContext();
        page=context.newPage();
        page.navigate("https://dev.automationtesting.in/table");


    }
    @When("Perform leftclick on the mouse")
    public void perform_leftclick_on_the_mouse() {
         page.locator("//tbody/tr[1]/td[2]")
        .click(new Locator.ClickOptions().setButton(MouseButton.LEFT));
    }
    @Then("Close the browser..")
    public void close_the_browser() {
        page.close();
        browser.close();

    }

}
