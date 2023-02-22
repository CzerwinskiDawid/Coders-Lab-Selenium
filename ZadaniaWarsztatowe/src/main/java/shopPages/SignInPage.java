package shopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-email")
    private WebElement emailInput;
    @FindBy(id = "field-password")
    private WebElement passwordInput;
    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public void signIn(String email, String password) {
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        signInButton.click();
    }


}
