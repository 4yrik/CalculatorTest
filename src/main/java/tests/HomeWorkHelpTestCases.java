package tests;

import org.junit.Assert;

import java.util.*;

public class HomeWorkHelpTestCases extends BaseTestCases {

    public List<String[]> testData() {
        return Arrays.asList(
                new String [][]{
                        {"Biology Assignment", "Undergraduate", "14 days", "9.97"},
                        {"Chemistry Assignment", "Bachelor", "10 days", "18"},
                        {"Engineering Assignment", "Professional", "6 days", "24"},
                        {"Geography Assignment", "Undergraduate", "3 days", "18"},
                        {"Math Assignment", "Bachelor", "2 days", "25"},
                        {"Physics Assignment", "Professional", "24 hours", "3"},
                        {"Programming Assignment", "Undergraduate", "12 hours", "26"},
                        {"Other Assignment", "Bachelor", "6 hours", "34"},
                        {"Biology Assignment", "Professional", "3 hours", "56"}
                }
        );
    }

    public void testCase(){
        for(int i = 0; i < testData().size(); i++){
            calculatorPage.selectTypeOfPaper(testData().get(i)[0]);
            try {
                String pagesName = calculatorPage.getPagesFieldName();
                Assert.assertEquals("Problems", pagesName);
                report.append(String.format("%s Type of Paper \"%s\" pages name is \"Problems\"\n", this.getClass().getSimpleName(), testData().get(i)[0]));
            }catch (Error e){
                report.append(String.format("%s Type of Paper \"%s\" pages name is NOT \"Problems\"\n", this.getClass().getSimpleName(), testData().get(i)[0]));
            }
        }
        checkPrice();
        writeReport();
    }
}
