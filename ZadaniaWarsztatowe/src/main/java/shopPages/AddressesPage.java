package shopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy(css = ".alert")
    private WebElement deleteAddressAlert;

    public void createNewAddress() {
        createNewAddressButton.click();
    }

    public String getSuccessAlertText(){
        return successAlert.getText();
    }

    public String getNewAddressText() {
        return newAddressDetails.getText();
    }
    public String getDeleteAddressAlert() {
        return deleteAddressAlert.getText();
    }

    public void deleteAddress() {
        List<WebElement> elements = driver.findElements(By.xpath("//a[@data-link-action=\"delete-address\"]"));
        WebElement element = elements.get(1);

        element.click();
    }
}
