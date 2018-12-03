import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAction {
    @FindBy(xpath="//input[@name='userName']")
    private WebElement loginField;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath="//input[@name='login']")
    private WebElement signInButton;

    private Wait<WebDriver> wait;

    public LoginAction(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 10, 1000);
    }

    public void login(String login, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginField)).sendKeys(login);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }
}
