package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.List;

public class PWCalculatorPage implements CalculatorPage {

    private WebDriver driver;

    @FindBy(xpath = "//select[@name=\"service_type\"]//option")
    private List<WebElement> typesOfPaper;

    @FindBy(xpath = "//select[@name=\"academic_level\"]//option")
    private List<WebElement> academicLevels;

    @FindBy(xpath = "//select[@name=\"deadline\"]//option")
    private List<WebElement> deadlines;

    @FindBy(id = "price_div3")
    private WebElement price;

    @FindBy(id = "order_now_big_btn_main")
    private WebElement orderButton;

    @FindBy(xpath = "//*[@id=\"_calc_hidable\"]/div[4]//label")
    private WebElement pagesName;

    @FindBy(xpath = "//button[text() = \"Back to top\"]")
    private WebElement backToTopButton;

    @FindBy(id = "goBackModalWithTimer")
    private WebElement popUpWindow;

    @FindBy(xpath = "//*[@id=\"goBackModalWithTimer\"]//button[@class=\"close\"]")
    private WebElement closePopUpWindowButton;

    public PWCalculatorPage(WebDriver driver){
        driver.get("http://www.paperwritings.com/");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public PWCalculatorPage selectTypeOfPaper(String type){
        for(WebElement element: typesOfPaper){
            if(element.getText().equals(type)){
                element.click();
                return this;
            }
        }
        throw new IllegalArgumentException("There is no such type of paper: " + type);
    }

    public PWCalculatorPage selectAcademicLevel(String level){
        for(WebElement element: academicLevels){
            if(element.getText().equals(level)){
                element.click();
                return this;
            }
        }
        throw new IllegalArgumentException("There is no such academic level: " + level);
    }

    public PWCalculatorPage selectDeadLine(String ddl){
        for(WebElement element: deadlines){
            if(element.getText().equals(ddl)){
                element.click();
                return this;
            }
        }
        throw new IllegalArgumentException("There is no such deadline: " + ddl);
    }

    public CalculatorPage scrollToTop(){
        if (backToTopButton.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        }
        return this;
    }

    public CalculatorPage closePopUpWindow(){
        if(popUpWindow.isDisplayed()){
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView()", closePopUpWindowButton);
            closePopUpWindowButton.click();
        }
        return this;
    }

    public String getPrice(){
        return price.getText().substring(1);
    }
    public String getPagesFieldName(){
        return pagesName.getText().substring(0, pagesName.getText().length() - 1);
    }
    public void clickContinueButton(){
        orderButton.click();
    }
    public WebDriver getDriver(){
        return driver;
    }
}
