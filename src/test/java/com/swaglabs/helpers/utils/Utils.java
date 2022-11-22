package com.swaglabs.helpers.utils;

import com.swaglabs.helpers.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    private static Logger logger = LogManager.getLogger(Utils.class);

    /**
     * Take screenshot and save to default Selenium download directory path with file name {testMethodName-timeStamp}
     * Add this method wherever want to capture the screenshot. ie. on failure or assert.
     */
    public static void takeScreenshot(WebDriver driver) {
        String filePath = getSeleniumDefaultDownloadPath() + getScreenshotFileName();
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(filePath));
            logger.info("Screenshot captured: {}", filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String getScreenshotFileName() {
        String testName = "";
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < traceElements.length; i++) {
            if (traceElements[i].getFileName().contains("Test.java")) {
                testName = Thread.currentThread().getStackTrace()[i].getMethodName();
                break;
            }
        }
        return testName + "_" + new SimpleDateFormat("yyMMddhhmmssSS").format(new Date()) + ".png";
    }

    /**
     * Setting default directory path for selenium test downloads
     *
     * @return
     */
    public static String getSeleniumDefaultDownloadPath() {
        File directory = new File(Constants.DEFAULT_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdir();
        }
        return Constants.DEFAULT_DIRECTORY;
    }
    /**
     * @param daysToAddOrDeduct
     * @param format
     * @return formatted date
     */
    public static String getDate(int daysToAddOrDeduct, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, daysToAddOrDeduct);
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    /**
     * @return current date with mm/dd/yyyy format
     */
    public static String getDate() {
        return getDate(0, "MM/dd/yyyy");
    }

    /**
     * @param addDays, for past dates add '-', ie. -10
     * @return date with mm/dd/yyyy format
     */
    public static String getDate(int addDays) {
        return getDate(addDays, "MM/dd/yyyy");
    }

}
