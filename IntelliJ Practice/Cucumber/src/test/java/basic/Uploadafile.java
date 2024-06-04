package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.file.Paths;

public class Uploadafile {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    @Given("Launch website")
    public void launch_website() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.automationtesting.in/FileUpload.html");

    }
    @When("Upload a file")
    public void upload_a_file() {
        page.setInputFiles("//input[@id='input-4']", Paths.get("Screenshort/logo.png"));

    }
    @Then("Closing Browser")
    public void closing_browser() {
        page.close();
        browser.close();


    }

}
