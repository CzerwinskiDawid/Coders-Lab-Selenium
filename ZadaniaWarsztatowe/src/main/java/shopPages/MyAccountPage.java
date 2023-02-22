package shopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String loginConfirmation() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".hidden-sm-down"));
        WebElement element = elements.get(4);
        return element.getText();
    }

    public void addresses() {
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class=\"link-item\"]"));
        WebElement addressesButton = elements.get(1);
        addressesButton.click();
    }
}
