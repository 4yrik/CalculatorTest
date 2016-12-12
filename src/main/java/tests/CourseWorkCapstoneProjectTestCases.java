package tests;

import java.util.*;

public class CourseWorkCapstoneProjectTestCases extends BaseTestCases {

    public List<String[]> testData() {
        return Arrays.asList(
                new String[][]{
                        {"Course work", "Undergraduate", "14 days", "10.97"},
                        {"Course work", "Bachelor", "10 days", "19"},
                        {"Course work", "Professional", "6 days", "25"},
                        {"Course work", "Undergraduate", "3 days", "19"},
                        {"Course work", "Bachelor", "2 days", "26"},
                        {"Course work", "Professional", "24 hours", "36"},
                        {"Course work", "Undergraduate", "12 hours", "27"},
                        {"Course work", "Bachelor", "6 hours", "35"},
                        {"Course work", "Professional", "3 hours", "57"},
                        {"Capstone project", "Bachelor", "14 days", "18"},
                        {"Capstone project", "Professional", "10 days", "23"},
                        {"Capstone project", "Bachelor", "6 days", "22"},
                        {"Capstone project", "Professional", "3 days", "30"},
                        {"Capstone project", "Bachelor", "2 days", "27"},
                        {"Capstone project", "Professional", "24 hours", "3"},
                        {"Capstone project", "Bachelor", "12 hours", "31"},
                        {"Capstone project", "Professional", "6 hours", "47"},
                        {"Capstone project", "Bachelor", "3 hours", "47"},
                }
        );
    }

    public void testCase(){
        checkPrice();
        writeReport();
    }
}
