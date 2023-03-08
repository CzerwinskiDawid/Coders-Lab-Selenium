package shopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "confirm-addresses")
    private WebElement addressConfirmationButton;
    @FindBy(name = "confirmDeliveryOption")
    private WebElement deliveryConfirmationButton;
    @FindBy(id = "payment-option-1")
    private WebElement payByCheckButton;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsAndConditions;
    @FindBy(xpath = "//button[@class=\"btn btn-primary center-block\"]")
    private WebElement placeOrderButton;

    public void addressConfirmation() {
        addressConfirmationButton.click();
    }

    public void deliveryConfirmation() {
        deliveryConfirmationButton.click();
    }

    public void paymentOption() {
        payByCheckButton.click();
        termsAndConditions.click();
    }

    public void orderConfirmation() {
        placeOrderButton.click();
    }
}
