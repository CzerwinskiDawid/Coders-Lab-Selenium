package shop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import shopPages.MainPage;
import shopPages.MyAccountPage;
import shopPages.SignInPage;

import java.time.Duration;

public class AddingAddressDefs {

    private WebDriver driver;

    @Given("User is on the main page")
    public void shopSetup() {
      System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://mystore-testlab.coderslab.pl/index.php");
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }
    @When("He logs in with the correct data: email {}, password {}")
    public void signIn(String email, String password) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(email, password);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals("Karol Nowak", myAccountPage.loginConfirmation());
        myAccountPage.addresses();
    }
//    @And("Will add address details: Alias {}, Address {}, City {}, Postal code {}, Country {}, Phone {}")
//    public void addingNewAddress() {
//
//    }

//    @After
//    public void cleanup() {
//        driver.quit();
//    }
}
