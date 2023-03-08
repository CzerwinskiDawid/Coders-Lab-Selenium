package shopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "_desktop_user_info")
    private WebElement signInButton;
    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInput;

    public void signIn() {
        signInButton.click();
    }

    public void searchingProduct(String productName) {
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchInput.submit();
    }
}
