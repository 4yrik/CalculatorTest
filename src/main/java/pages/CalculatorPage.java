package pages;

import org.openqa.selenium.WebDriver;

public interface CalculatorPage {

    CalculatorPage selectTypeOfPaper(String type);
    CalculatorPage selectAcademicLevel(String level);
    CalculatorPage selectDeadLine(String ddl);
    CalculatorPage scrollToTop();
    CalculatorPage closePopUpWindow();
    String getPrice();
    void clickContinueButton();
    WebDriver getDriver();
    String getPagesFieldName();
}
