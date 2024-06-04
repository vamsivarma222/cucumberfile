package basic;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.file.Paths;

public class FileDownload {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private Download download;
    @Given("Launch the website")
    public void launch_the_website() throws InterruptedException {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true)
                .setDownloadsPath(Paths.get("downloads")));
        context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
        page = context.newPage();
        page.navigate("https://filesamples.com/formats/pdf");
        Thread.sleep(6000);
    }
    @When("Download a file")
    public void download_a_file() throws InterruptedException {
      download= page.waitForDownload(() -> {
          download = page.waitForDownload(new Page.WaitForDownloadOptions().setTimeout(60000), () -> {
              page.click("//div[@class='output']//div[1]//a[1]");
          });
 });

        download.saveAs(Paths.get("downloads/vamsi.pdf"));
        Thread.sleep(6000);
    }
    @Then("Close the browser,")
    public void close_the_browser() {
        page.close();
        browser.close();

    }
}
