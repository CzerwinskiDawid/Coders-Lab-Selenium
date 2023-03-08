package shopPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "group_1")
    private WebElement sizeSelection;
    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;
    @FindBy(xpath = "//a[@class=\"btn btn-primary\"]")
    private WebElement proceedToCheckout;

    public void setSizeSelection() {
        sizeSelection.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void quaintity(String value) throws InterruptedException {
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, Keys.chord(value), Keys.ENTER);
    }

    public void addToCart() {
        proceedToCheckout.click();
    }
}
