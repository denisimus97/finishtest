import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBookAction {
    @FindBy(xpath="//tr/td[@class='frame_header_info'][1]/b/font")
    WebElement fromPort;

    @FindBy(xpath="//tr/td[@class='frame_header_info'][2]/b/font")
    WebElement fromDate;

    @FindBy(xpath="//tr[3]/td[@class='data_left']/font/b")
    WebElement fromFlight;

    @FindBy(xpath="//tr[3]/td[@class='data_center_mono']/font")
    WebElement fromClass;

    @FindBy(xpath="//tr[3]/td[@class='data_center']/font")
    WebElement fromPrice;

    @FindBy(xpath="//tr[4]/td[@class='data_left']/b/font")
    WebElement toPort;

    @FindBy(xpath="//tr[4]/td[@class='data_center_mono']/b/font")
    WebElement toDate;

    @FindBy(xpath="//tr[6]/td[@class='data_left']/font/font/font/b")
    WebElement toFlight;

    @FindBy(xpath="//tr[6]/td[@class='data_center_mono']/font")
    WebElement toClass;

    @FindBy(xpath="//tr[6]/td[@class='data_center']/font")
    WebElement toPrice;

    @FindBy(xpath="//tr[8]/td[2]/font")
    WebElement taxes;

    @FindBy(xpath="//tr[9]/td[2]/font/b")
    WebElement summary;

    @FindBy(xpath="//input[@name='passFirst0']")
    WebElement pass1First;

    @FindBy(xpath="//input[@name='passLast0']")
    WebElement pass1Last;

    @FindBy(xpath="//select[@name='pass.0.meal']/option[@value='HNML']")
    WebElement pass1Meal;

    @FindBy(xpath="//input[@name='passFirst1']")
    WebElement pass2First;

    @FindBy(xpath="//input[@name='passLast1']")
    WebElement pass2Last;

    @FindBy(xpath="//select[@name='pass.1.meal']/option[@value='BLML']")
    WebElement pass2Meal;

    @FindBy(xpath="//select[@name='creditCard']/option[@value='BA']")
    WebElement cardType;

    @FindBy(xpath="//input[@name='creditnumber']")
    WebElement cardNumber;

    @FindBy(xpath="//select[@name='cc_exp_dt_mn']/option[6]")
    WebElement expiration1;

    @FindBy(xpath="//select[@name='cc_exp_dt_yr']/option[11]")
    WebElement expiration2;

    @FindBy(xpath="//input[@name='cc_frst_name']")
    WebElement cardFName;

    @FindBy(xpath="//input[@name='cc_mid_name']")
    WebElement cardMName;

    @FindBy(xpath="//input[@name='cc_last_name']")
    WebElement cardLName;

    @FindBy(xpath="//input[@name='billAddress1']")
    WebElement bAddress;

    @FindBy(xpath="//input[@name='billCity']")
    WebElement bCity;

    @FindBy(xpath="//input[@name='billState']")
    WebElement bState;

    @FindBy(xpath="//input[@name='billZip']")
    WebElement bCode;

    @FindBy(xpath="//tbody/tr[15]//input[@name='ticketLess']")
    WebElement dCheckbox;

    @FindBy(xpath="//input[@name='delAddress1']")
    WebElement dAddress;

    @FindBy(xpath="//input[@name='delCity']")
    WebElement dCity;

    @FindBy(xpath="//input[@name='delState']")
    WebElement dState;

    @FindBy(xpath="//input[@name='delZip']")
    WebElement dCode;

    @FindBy(xpath="//input[@name='buyFlights']")
    WebElement button;

    private WebDriver driver;
    private Wait<WebDriver> wait;
    private int tax;

    public FlightBookAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10, 1000);
    }

    public void check(int fPrice, int tPrice) {
        Assert.assertEquals(fromPort.getText(), "Paris to Seattle");
        Assert.assertEquals(fromDate.getText(), "11/20/2018");
        Assert.assertEquals(fromFlight.getText(), "Unified Airlines 363");
        Assert.assertEquals(fromClass.getText(), "Business");
        Assert.assertEquals(fromPrice.getText(), fPrice + "");
        Assert.assertEquals(toPort.getText(), "Seattle to Paris");
        Assert.assertEquals(toDate.getText(), "12/19/2018");
        Assert.assertEquals(toFlight.getText(), "Blue Skies Airlines 631");
        Assert.assertEquals(toClass.getText(), "Business");
        Assert.assertEquals(toPrice.getText(), tPrice + "");

        tax = Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(taxes)).getText().substring(1));
        int sum = (fPrice + tPrice) * 2 + tax;

        Assert.assertEquals(summary.getText().substring(1), sum + "");
    }

    public void fill() {
        wait.until(ExpectedConditions.visibilityOf(pass1First)).sendKeys("Ivanov");
        wait.until(ExpectedConditions.visibilityOf(pass1Last)).sendKeys("Ivan");
        wait.until(ExpectedConditions.elementToBeClickable(pass1Meal)).click();
        wait.until(ExpectedConditions.visibilityOf(pass2First)).sendKeys("Ivanova");
        wait.until(ExpectedConditions.visibilityOf(pass2Last)).sendKeys("Irina");
        wait.until(ExpectedConditions.elementToBeClickable(pass2Meal)).click();

        wait.until(ExpectedConditions.elementToBeClickable(cardType)).click();
        wait.until(ExpectedConditions.visibilityOf(cardNumber)).sendKeys("5479540454132487");
        wait.until(ExpectedConditions.elementToBeClickable(expiration1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(expiration2)).click();
        wait.until(ExpectedConditions.visibilityOf(cardFName)).sendKeys("Ivan");
        wait.until(ExpectedConditions.visibilityOf(cardMName)).sendKeys("Ivanovich");
        wait.until(ExpectedConditions.visibilityOf(cardLName)).sendKeys("Ivanov");

        wait.until(ExpectedConditions.visibilityOf(bAddress)).clear();
        bAddress.sendKeys("1085 Borregas Ave.");
        wait.until(ExpectedConditions.visibilityOf(bCity)).clear();
        bCity.sendKeys("Albuquerque");
        wait.until(ExpectedConditions.visibilityOf(bState)).clear();
        bState.sendKeys("New Mexico");
        wait.until(ExpectedConditions.visibilityOf(bCode)).clear();
        bCode.sendKeys("94089");

        wait.until(ExpectedConditions.elementToBeClickable(dCheckbox)).click();
        wait.until(ExpectedConditions.visibilityOf(dAddress)).clear();
        dAddress.sendKeys("1225 Borregas Ave.");
        wait.until(ExpectedConditions.visibilityOf(dCity)).clear();
        dCity.sendKeys("Boston");
        wait.until(ExpectedConditions.visibilityOf(dState)).clear();
        dState.sendKeys("Massachusetts");
        wait.until(ExpectedConditions.visibilityOf(dCode)).clear();
        dCode.sendKeys("91089");

        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    public int getTaxes() {
        return this.tax;
    }
}
