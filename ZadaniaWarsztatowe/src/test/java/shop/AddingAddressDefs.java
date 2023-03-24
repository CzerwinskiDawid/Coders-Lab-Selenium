package shop;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import shopPages.*;

import java.time.Duration;

public class AddingAddressDefs {

    private WebDriver driver;


    @Given("The user is registered, has the first address added and is on the home page")
    public void shopSetup() {
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

    @When("He logs in with the correct data: email {}, password {}")
    public void signIn(String email, String password) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(email, password);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals("Karol Nowak", myAccountPage.loginConfirmation());
        myAccountPage.addresses();

        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.createNewAddress();
    }

    @And("Will add address details: Alias {}, Address {}, City {}, Postal code {}, Country {}, Phone {}")
    public void addingNewAddress(String alias, String address, String city, String postalCode, String country, String phoneNumber) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.addNewAddress(alias, address, city, postalCode, country, phoneNumber);
    }

    @Then("New address should contain \"address details\": {}, {}, {}, {}, {}, {}")
    public void assertContainWord(String expectedAlias, String expectedAddress, String expectedCity, String expectedPostalCode, String expectedCountry, String expectedPhoneNumber) {
        AddressesPage addressesPage = new AddressesPage(driver);
        Assert.assertEquals("Address successfully added!", addressesPage.getSuccessAlertText());
        Assert.assertTrue(addressesPage.getNewAddressText().contains(expectedAlias));
        Assert.assertTrue(addressesPage.getNewAddressText().contains(expectedAddress));
        Assert.assertTrue(addressesPage.getNewAddressText().contains(expectedCity));
        Assert.assertTrue(addressesPage.getNewAddressText().contains(expectedPostalCode));
        Assert.assertTrue(addressesPage.getNewAddressText().contains(expectedCountry));
        Assert.assertTrue(addressesPage.getNewAddressText().contains(expectedPhoneNumber));
    }

    @Then("User can delete this address")
    public void deletingNewAddress() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.deleteAddress();
        Assert.assertEquals("Address successfully deleted!", addressesPage.getDeleteAddressAlert());
    }

//    @After
//    public void cleanup() {
//        driver.quit();
//    }
}
