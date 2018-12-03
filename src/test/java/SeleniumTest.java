import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {
    private static WebDriver driver;
    private int fromPrice;
    private int toPrice;

    @BeforeClass
    public static void create() {
        System.setProperty("webdriver.chrome.driver", "D:/Java projects/chromedriver.exe");
        driver = new ChromeDriver();
//		driver.manage().window().maximize();
        driver.get("http://newtours.demoaut.com/");
    }

    @Test
    public void login() {
        LoginAction loginAction = new LoginAction(driver);
        PageFactory.initElements(driver, loginAction);
        loginAction.login("test1", "test1");

        Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");

        FlightFinderAction ffa = new FlightFinderAction(driver);
        PageFactory.initElements(driver, ffa);
        ffa.fill();

        Assert.assertEquals(driver.getTitle(), "Select a Flight: Mercury Tours");

        FlightSelectAction fsa = new FlightSelectAction(driver);
        PageFactory.initElements(driver, fsa);
        fsa.check();
        fsa.select();
        int fromPrice = fsa.getFromPrice();
        int toPrice = fsa.getToPrice();

        Assert.assertEquals(driver.getTitle(), "Book a Flight: Mercury Tours");

        FlightBookAction fba = new FlightBookAction(driver);
        PageFactory.initElements(driver, fba);
        fba.check(fromPrice, toPrice);
        fba.fill();
        int taxes = fba.getTaxes();

        Assert.assertEquals(driver.getTitle(), "Flight Confirmation: Mercury Tours");

        FlightConfirmAction fca = new FlightConfirmAction(driver);
        PageFactory.initElements(driver, fca);

        int sum = (fromPrice + toPrice) * 2 + taxes;
        fca.confirm(sum);
    }

    @AfterClass
    public static void destroy() {

    }
}