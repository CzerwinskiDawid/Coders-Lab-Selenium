package shopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement postCodeInput;

    @FindBy(id = "field-id_country")
    private WebElement countrySelect;

    @FindBy(xpath = "//option[@value=\"17\"]")
    private WebElement unitedKingdom;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(css = ".btn")
    private WebElement submitButton;

    public void addNewAddress(String alias, String address, String city, String postalCode, String country, String phoneNumber) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        postCodeInput.clear();
        postCodeInput.sendKeys(postalCode);

        countrySelect.click();

        unitedKingdom.click();

        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);

        submitButton.submit();
    }

}
