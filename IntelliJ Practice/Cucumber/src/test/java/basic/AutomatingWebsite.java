package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomatingWebsite {
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @Given("Launching  browser")
    public void launching_browser() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://luma-demo.scandipwa.com/men.html");
    }
    @When("To perform multiple operation of the website")
    public void to_perform_multiple_operation_of_the_website() throws InterruptedException {

      page.click("//li[1]//a[1]//div[1]//div[1]//figure[1]//div[1]//img[1]");
        Thread.sleep(3000);
        page.click("//div[@id='color_wrapper']//div[@class='FieldSelect-Clickable']");
        Thread.sleep(3000);
        page.click("//li[@id='o395125']");
        Thread.sleep(3000);
        page.click("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(5) > main:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > article:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)");
        Thread.sleep(3000);
        page.click("//li[@id='o395242']");
        Thread.sleep(3000);
        page.click(".Button.AddToCart.Button.AddToCart_layout_grid.ProductActions-AddToCart");
        Thread.sleep(3000);
        page.click("//*[name()='path' and contains(@d,'M20.703 4.')]");
        Thread.sleep(3000);
        page.click("//button[@class='CartOverlay-CheckoutButton Button']");
        Thread.sleep(3000);
        page.fill("//input[@placeholder='Your first name']","vamsi");
        Thread.sleep(3000);
        page.fill("//input[@placeholder='Your last name']","varma");
        Thread.sleep(3000);
        page.fill("//input[@placeholder='Your street address line 1']","ahsgdfskajgsdkgfkhasdgfgdsfkjhgdfshdg");
        Thread.sleep(3000);
        page.click("//div[@id='address-country-id_wrapper']//div[@class='FieldSelect-Clickable']");
        page.click("//li[@id='oAF']");
        Thread.sleep(3000);
        page.fill("//input[@id='address-region-id']","andhrapradesh");
        page.fill("//input[@placeholder='Your zip / postal code']","530046");
        page.fill("//input[@placeholder='Your phone number']","99999999999");
        page.check("//input[@id='option-Standard Post']");
        page.click("//button[normalize-space()='Proceed to billing']");
    }
    @Then("Close the browser...")
    public void close_the_browser() {
        page.close();
        browser.close();
    }
}

