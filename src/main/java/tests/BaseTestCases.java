package tests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pages.CalculatorPage;
import util.Utils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class BaseTestCases {

    protected static CalculatorPage calculatorPage;
    protected static StringBuilder report = new StringBuilder();

    public abstract List<String[]> testData();

    public abstract void testCase();

    public static void setCalculatorPage(CalculatorPage _calculatorPage){
        calculatorPage = _calculatorPage;
    }

    @Test
    protected void checkPrice(){
        report.append(this.getClass().getSimpleName() + " - " + calculatorPage.getDriver().getClass().getSimpleName() + "\n");
        List<String[]> data = testData();

        for (int i = 0; i < data.size(); i++) {
            String[] currentTestData = data.get(i);
            try {
                calculatorPage.selectTypeOfPaper(currentTestData[0]).
                               selectAcademicLevel(currentTestData[1]).
                               selectDeadLine(currentTestData[2]).
                               scrollToTop().
                               closePopUpWindow();
                String actualPrice = calculatorPage.getPrice();
                Assert.assertEquals(currentTestData[3], actualPrice);
                report.append(String.format("Prices are equal! Expected %s, actual %s. Test case %d PASS\n", currentTestData[3], actualPrice, i + 1));
            } catch (IllegalArgumentException e) {
                report.append(String.format("Test case %d %s\n", i + 1, e.getMessage()));
            } catch (Error e) {
                report.append(String.format("Prices are NOT equal! Expected %s, actual %s. Test case %d FAIL\n", currentTestData[3], calculatorPage.getPrice(), i + 1));
                Utils.takeScreeshot(this.getClass().getSimpleName(), calculatorPage.getDriver(), String.format("TC%d", i + 1), calculatorPage.getDriver().getClass().getSimpleName());
            }
        }
    }

    @Test
    protected void goToOF(){
        try {
            calculatorPage.clickContinueButton();
            new WebDriverWait(calculatorPage.getDriver(), 10).until(ExpectedConditions.titleIs("PaperWritings.com - Order Custom Papers Right Away!"));
            report.append("Current page is Order Form!\n");
        } catch (TimeoutException e) {
            report.append("Current page is NOT Order Form!\n");
        }
        try {
            calculatorPage = calculatorPage.getClass().getConstructor(WebDriver.class).newInstance(calculatorPage.getDriver());
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }

    protected void writeReport(){
        System.out.println(report.toString());
        Utils.reportToFile(this.getClass().getSimpleName(), report, calculatorPage.getDriver().getClass().getSimpleName());
        report = new StringBuilder();
    }
}
