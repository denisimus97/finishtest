import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmAction {
    @FindBy(xpath="//tbody/tr[3]/td[@class='frame_header_info']/font")
    WebElement dConfirm;

    @FindBy(xpath="//tbody/tr[5]/td[@class='frame_header_info']/font")
    WebElement rConfirm;

    @FindBy(xpath="//tbody/tr[7]/td/font")
    WebElement pass;

    @FindBy(xpath="//tbody/tr[9]/td/p/font[1]")
    WebElement bInfo;

    @FindBy(xpath="//tbody/tr[11]/td/p/font[1]")
    WebElement dInfo;

    @FindBy(xpath="//tbody/tr[12]//tbody/tr[2]/td[2]/font/b/font/font/b/font")
    WebElement summary;

    @FindBy(xpath="//td/a[@href='mercurywelcome.php']")
    WebElement button;

    private WebDriver driver;
    private Wait<WebDriver> wait;

    public FlightConfirmAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10, 1000);
    }

    public void confirm(int sum) {
        String dConfirmText = dConfirm.getText();
        if (!(dConfirmText.contains("Paris to Seattle")      &&
                dConfirmText.contains("11/20/2018")            &&
                dConfirmText.contains("Unified Airlines 363")  &&
                dConfirmText.contains("Business")              &&
                dConfirmText.contains("281"))) {
            Assert.fail();
        }

        String rConfirmText = rConfirm.getText();
        if (!(rConfirmText.contains("Seattle to Paris")       &&
                rConfirmText.contains("2/19/2018")               &&
                rConfirmText.contains("Blue Skies Airlines 631") &&
                rConfirmText.contains("Business")                &&
                rConfirmText.contains("273"))) {
            Assert.fail();
        }

        Assert.assertEquals(pass.getText(), "2 passengers");

        String bInfoText = bInfo.getText();
        if (!(bInfoText.contains("Ivan Ivanovich Ivanov") &&
                bInfoText.contains("1085 Borregas Ave.")	  &&
                bInfoText.contains("Albuquerque, New Mexico, 94089"))) {
            Assert.fail();
        }

        String dInfoText = dInfo.getText();
        if (!(dInfoText.contains("1225 Borregas Ave.") &&
                dInfoText.contains("Boston, Massachusetts, 91089"))) {
            Assert.fail();
        }

        Assert.assertEquals(summary.getText().substring(1, summary.getText().length() - 4), sum + "");
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
}