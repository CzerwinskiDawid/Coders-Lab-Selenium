package shopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@loading=\"lazy\"]")
    private WebElement product;

    public void selectedProduct() {
        product.click();
    }
}
