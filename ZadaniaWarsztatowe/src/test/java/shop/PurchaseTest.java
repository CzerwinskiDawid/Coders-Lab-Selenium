package shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import shopPages.*;

import java.time.Duration;

public class PurchaseTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }
    @Test
    public void shopping() {
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

    }

//    @After
//    public void cleanup() {
//        driver.quit();
//    }
}
