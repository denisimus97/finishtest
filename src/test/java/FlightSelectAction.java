import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSelectAction {
    @FindBy(xpath="//table[1]//tr[2]/td[@class='title' and @align='LEFT']")
    WebElement fromFlight;

    @FindBy(xpath="//table[1]//tr[2]/td[@class='title' and @align='RIGHT']")
    WebElement fromDate;

    @FindBy(xpath="//table[2]//tr[2]/td[@class='title' and @align='LEFT']")
    WebElement toFlight;

    @FindBy(xpath="//table[2]//tr[2]/td[@class='title' and @align='RIGHT']")
    WebElement toDate;

    @FindBy(xpath="//input[@type='radio' and @name='outFlight' and contains(@value, 'Unified Airlines$363')]")
    WebElement fromFlightField;

    @FindBy(xpath="//input[@type='radio' and @name='inFlight' and contains(@value, 'Blue Skies Airlines$631')]")
    WebElement toFlightField;

    @FindBy(xpath="//input[@name='reserveFlights']")
    WebElement reserveButton;

    private WebDriver driver;
    private Wait<WebDriver> wait;
    private int fromPrice = 0;
    private int toPrice = 0;

    public FlightSelectAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10, 1000);
    }

    public void check() {
        Assert.assertEquals(fromFlight.getText(), "Paris to Seattle");
        Assert.assertEquals(fromDate.getText(), "11/20/2018");
        Assert.assertEquals(toFlight.getText(), "Seattle to Paris");
        Assert.assertEquals(toDate.getText(), "12/19/2018");
    }

    public void select() {
        wait.until(ExpectedConditions.elementToBeClickable(fromFlightField)).click();
        this.fromPrice = 281;
        wait.until(ExpectedConditions.elementToBeClickable(toFlightField)).click();
        this.toPrice = 273;
        wait.until(ExpectedConditions.elementToBeClickable(reserveButton)).click();
    }

    public int getFromPrice() {
        return this.fromPrice;
    }

    public int getToPrice() {
        return this.toPrice;
    }
}
