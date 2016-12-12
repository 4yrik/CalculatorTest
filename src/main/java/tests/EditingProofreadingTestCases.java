package tests;

import java.util.*;

public class EditingProofreadingTestCases extends BaseTestCases {

    public List<String[]> testData() {
        return Arrays.asList(
                new String[][]{
                        {"Editing/proofreading", "Undergraduate", "14 days", "5.98"},
                        {"Editing/proofreading", "Bachelor", "10 days", "11"},
                        {"Editing/proofreading", "Professional", "6 days", "14"},
                        {"Editing/proofreading", "Undergraduate", "3 days", "11"},
                        {"Editing/proofreading", "Bachelor", "2 days", "15"},
                        {"Editing/proofreading", "Professional", "24 hours", "21"},
                        {"Editing/proofreading", "Undergraduate", "12 hours", "16"},
                        {"Editing/proofreading", "Bachelor", "6 hours", "20"},
                        {"Editing/proofreading", "Professional", "3 hours", "3"}
                }
        );
    }

    public void testCase(){
        checkPrice();
        goToOF();
        writeReport();
    }
}
