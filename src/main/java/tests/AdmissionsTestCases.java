package tests;

import java.util.*;

public class AdmissionsTestCases extends BaseTestCases {

    public List<String[]> testData() {
        return Arrays.asList(
                new String[][]{
                        {"Admission essay", "Undergraduate", "14 days", "41"},
                        {"Application letter", "Bachelor", "10 days", "45"},
                        {"Cover letter", "Professional", "6 days", "51"},
                        {"Curriculum vitae", "Undergraduate", "3 days", "54"},
                        {"Personal statement", "Bachelor", "2 days", "6"},
                        {"Resume", "Professional", "24 hours", "72"},
                        {"Admission essay", "Undergraduate", "12 hours", "128"},
                        {"Application letter", "Bachelor", "6 hours", "170"},
                        {"Cover letter", "Professional", "3 hours", "197"}
                }
        );
    }

    public void testCase(){
        checkPrice();
        writeReport();
    }
}
