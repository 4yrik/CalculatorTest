package tests;

import org.junit.Assert;
import java.util.*;

public class IrregularPricingTestCases extends BaseTestCases {

    public List<String[]> testData() {
        return Arrays.asList(
                new String[][]{
                        {"Multiple choice questions", "Undergraduate", "14 days", "1"},
                        {"Multiple choice questions", "Bachelor", "10 days", "1.8"},
                        {"Multiple choice questions", "Professional", "6 days", "2.4"},
                        {"Multiple choice questions", "Undergraduate", "3 days", "1.8"},
                        {"Multiple choice questions", "Bachelor", "2 days", "2.5"},
                        {"Multiple choice questions", "Professional", "24 hours", "3.5"},
                        {"Multiple choice questions", "Undergraduate", "12 hours", "2.6"},
                        {"Multiple choice questions", "Bachelor", "6 hours", "3.4"},
                        {"Multiple choice questions", "Professional", "3 hours", "5.6"},
                        {"Problem solving", "Undergraduate", "14 days", "15"},
                        {"Problem solving", "Bachelor", "10 days", "2"},
                        {"Problem solving", "Professional", "6 days", "36"},
                        {"Problem solving", "Undergraduate", "3 days", "27"},
                        {"Problem solving", "Bachelor", "2 days", "38"},
                        {"Problem solving", "Professional", "24 hours", "53"},
                        {"Problem solving", "Undergraduate", "12 hours", "39"},
                        {"Problem solving", "Bachelor", "6 hours", "51"},
                        {"Problem solving", "Professional", "3 hours", "84"},
                }
        );
    }

    public void testCase(){
        calculatorPage.selectTypeOfPaper(testData().get(0)[0]);
        try {
            String pagesName = calculatorPage.getPagesFieldName();
            Assert.assertEquals("Question", pagesName);
            report.append(String.format("%s Type of Paper \"Multiple Choice Questions\" pages name is \"Questions\"\n", this.getClass().getSimpleName()));
        }catch (Error e){
            report.append(String.format("%s Type of Paper \"Multiple Choice Questions\" pages name is NOT \"Questions\"\n", this.getClass().getSimpleName()));
        }
        calculatorPage.selectTypeOfPaper(testData().get(9)[0]);
        try {
            String pagesName = calculatorPage.getPagesFieldName();
            Assert.assertEquals("Problem", pagesName);
            report.append(String.format("%s Type of Paper \"Problem solving\" pages name is \"Problems\"\n", this.getClass().getSimpleName()));
        }catch (Error e){
            report.append(String.format("%s Type of Paper \"Problem solving\" pages name is NOT \"Problems\"\n", this.getClass().getSimpleName()));
        }
        checkPrice();
        writeReport();
    }
}
