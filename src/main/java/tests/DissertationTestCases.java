package tests;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.*;

public class DissertationTestCases extends BaseTestCases {

    public List<String[]> testData() {
        return Arrays.asList(
                new String[][]{
                        {"Dissertation", "Professional", "14 days", "19"},
                        {"Dissertation abstract", "Professional", "10 days", "2"},
                        {"Dissertation chapter", "Professional", "6 days", "24"},
                        {"Dissertation conclusion", "Professional", "3 days", "28"},
                        {"Dissertation hypothesis", "Professional", "2 days", "31"},
                        {"Dissertation introduction", "Professional", "24 hours", "35"},
                        {"Dissertation methodology", "Professional", "12 hours", "39"},
                        {"Dissertation proposal", "Professional", "6 hours", "45"},
                        {"Dissertation results", "Professional", "3 hours", "56"}
                }
        );
    }

    public void testCase(){
        calculatorPage.selectTypeOfPaper(testData().get(0)[0]);
        try {
            String academicLevel = calculatorPage.getDriver().findElement(By.xpath("//select[@name=\"academic_level\"]//option[@selected=\"selected\"]")).getText();
            Assert.assertEquals("Professional", academicLevel);
            report.append(String.format("%s Type of Paper \"Dissertation\" Academic level is \"Professional\"\n", this.getClass().getSimpleName()));
        }catch (Error e){
            report.append(String.format("%s Type of Paper \"Dissertation\" Academic level is NOT \"Professional\"\n", this.getClass().getSimpleName()));
        }
        checkPrice();
        goToOF();
        writeReport();
    }
}
