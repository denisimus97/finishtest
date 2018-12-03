import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightFinderAction {
    @FindBy(xpath="//input[@value='oneway']")
    WebElement typeField;

    @FindBy(xpath="//select[@name='passCount']/option[@value='2']")
    WebElement passCountIs2Field;

    @FindBy(xpath="//select[@name='fromPort']/option[@value='Paris']")
    WebElement departingFromParisField;

    @FindBy(xpath="//select[@name='fromMonth']/option[@value='11']")
    WebElement fromMonthIsNovemberField;

    @FindBy(xpath="//select[@name='fromDay']/option[@value='20']")
    WebElement fromDayIs20Field;

    @FindBy(xpath="//select[@name='toPort']/option[@value='Seattle']")
    WebElement arrivingToSeattleField;

    @FindBy(xpath="//select[@name='toDay']/option[@value='19']")
    WebElement toDayIs19Field;

    @FindBy(xpath="//input[@value='Business']")
    WebElement servClassField;

    @FindBy(xpath="//select[@name='airline']/option[text()='Pangea Airlines']")
    WebElement airlineField;

    @FindBy(xpath="//input[@name='findFlights']")
    WebElement findButton;

    private Wait<WebDriver> wait;

    public FlightFinderAction(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 10, 1000);
    }

    public void fill() {
        wait.until(ExpectedConditions.elementToBeClickable(typeField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(passCountIs2Field)).click();
        wait.until(ExpectedConditions.elementToBeClickable(departingFromParisField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fromMonthIsNovemberField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fromDayIs20Field)).click();
        wait.until(ExpectedConditions.elementToBeClickable(arrivingToSeattleField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(toDayIs19Field)).click();
        wait.until(ExpectedConditions.elementToBeClickable(servClassField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(airlineField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(findButton)).click();
    }
}
