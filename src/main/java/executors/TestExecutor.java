package executors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;
import tests.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestExecutor {

    private static List<BaseTestCases> testCases = new ArrayList<>();

    static {
        testCases.add(new AdmissionsTestCases());
        testCases.add(new CourseWorkCapstoneProjectTestCases());
        testCases.add(new EditingProofreadingTestCases());
        testCases.add(new HomeWorkHelpTestCases());
        testCases.add(new IrregularPricingTestCases());
        testCases.add(new StandartPricingTestCases());
        testCases.add(new DissertationTestCases());
    }

    public static void executeChromeTests(){
        System.setProperty("webdriver.chrome.driver", "/Users/user/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CalculatorPage calculatorPage = new PWCalculatorPage(driver);
        BaseTestCases.setCalculatorPage(calculatorPage);
        for(BaseTestCases cases: testCases){
            cases.testCase();
        }
        driver.quit();
    }

    public static void executeFirefoxTests(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CalculatorPage calculatorPage = new PWCalculatorPage(driver);
        BaseTestCases.setCalculatorPage(calculatorPage);
        for(BaseTestCases cases: testCases){
            cases.testCase();
        }
        driver.quit();
    }

    public static void executeHtmlUnitTests(){
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.setJavascriptEnabled(true);
        CalculatorPage calculatorPage = new PWCalculatorPage(driver);
        BaseTestCases.setCalculatorPage(calculatorPage);
        for(BaseTestCases cases: testCases){
            cases.testCase();
        }
        driver.quit();
    }

    public static void executePhantomJSTests(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        System.setProperty("phantomjs.binary.path", "/Users/user/Documents/phantomjs-2.1.1-macosx/bin/phantomjs");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/Users/user/Documents/phantomjs-2.1.1-macosx/bin/phantomjs");

        WebDriver driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CalculatorPage calculatorPage = new PWCalculatorPage(driver);
        BaseTestCases.setCalculatorPage(calculatorPage);
        for(BaseTestCases cases: testCases){
            cases.testCase();
        }
        driver.quit();
    }
}
