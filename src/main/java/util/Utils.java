package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.io.*;

public class Utils {

    public static void takeScreeshot(String className, WebDriver driver, String testcase, String browserName){
        new File("/Users/user/Documents/test/").mkdir();
        File dir = new File(String.format("/Users/user/Documents/test/%s/", className));
        dir.mkdir();
        try {
            if(!(driver instanceof HtmlUnitDriver)) {
                File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screen, new File(String.format("/Users/user/Documents/test/%s/%s-%s.png", className, testcase, browserName)));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void reportToFile(String className, StringBuilder report, String browserName){
        new File("/Users/user/Documents/test/").mkdir();
        File dir = new File(String.format("/Users/user/Documents/test/%s/", className));
        dir.mkdir();
        try(FileWriter fos = new FileWriter(new File(String.format("/Users/user/Documents/test/%s/%s-%s.txt", className, className, browserName)))){
            fos.write(report.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
