package shop;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import shopPages.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class PurchaseTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable notifications");
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }


    @Test
    public void shopping() throws InterruptedException, IOException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("nonorof900@mustbeit.com", "TEST1234");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.backToMainPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.searchingProduct("Hummingbird Printed Sweater");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.selectedProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.setSizeSelection();
        productPage.quaintity(String.valueOf(5));
        productPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.purchaseConfirmation();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.addressConfirmation();
        orderPage.deliveryConfirmation();
        orderPage.paymentOption();
        orderPage.orderConfirmation();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
        String screenshotPath = "C:\\Users\\Admin\\OneDrive\\Pulpit\\screenshot.png";
        FileUtils.copyFile(screenshotFile, new File(screenshotPath));

    }


    @After
    public void cleanup() {
        driver.quit();
    }
}
