package tests;

import java.util.*;

public class StandartPricingTestCases extends BaseTestCases {

    public List<String[]> testData() {
        return Arrays.asList(
                new String[][]{
                        {"Essay", "Undergraduate", "14 days", "9.97"},
                        {"Article", "Undergraduate", "10 days", "14"},
                        {"Business plan", "Undergraduate", "6 days", "16"},
                        {"Critical thinking", "Undergraduate", "3 days", "18"},
                        {"Report", "Undergraduate", "2 days", "20"},
                        {"Term paper", "Undergraduate", "24 hours", "23"},
                        {"Thesis statement", "Undergraduate", "12 hours", "26"},
                        {"Case study", "Undergraduate", "6 hours", "31"},
                        {"Biography", "Undergraduate", "3 hours", "41"},
                        {"Essay", "Bachelor", "14 days", "16"},
                        {"Article", "Bachelor", "10 days", "18"},
                        {"Business plan", "Bachelor", "6 days", "20"},
                        {"Critical thinking", "Bachelor", "3 days", "23"},
                        {"Report", "Bachelor", "2 days", "25"},
                        {"Term paper", "Bachelor", "24 hours", "27"},
                        {"Thesis statement", "Bachelor", "12 hours", "29"},
                        {"Case study", "Bachelor", "6 hours", "34"},
                        {"Biography", "Bachelor", "3 hours", "45"},
                        {"Essay", "Professional", "14 days", "19"},
                        {"Article", "Professional", "10 days", "21"},
                        {"Business plan", "Professional", "6 days", "24"},
                        {"Critical thinking", "Professional", "3 days", "28"},
                        {"Report", "Professional", "2 days", "31"},
                        {"Term paper", "Professional", "24 hours", "35"},
                        {"Thesis statement", "Professional", "12 hours", "39"},
                        {"Case study", "Professional", "6 hours", "45"},
                        {"Biography", "Professional", "3 hours", "5"}
                }
        );
    }

    public void testCase(){
        checkPrice();
        goToOF();
        writeReport();
    }
}

