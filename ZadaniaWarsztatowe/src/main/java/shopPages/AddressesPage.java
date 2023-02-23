package shopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {

    private WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-link-action=\"add-address\"]")
    private WebElement createNewAddressButton;

    @FindBy(id = "main")
    private WebElement newAddressDetails;

    @FindBy(css = ".alert")
    private WebElement successAlert;

    public void createNewAddress() {
        createNewAddressButton.click();
    }

    public String getSuccessAlertText(){
        return successAlert.getText();
    }

    public String getNewAddressText() {
        return newAddressDetails.getText();
    }
}
