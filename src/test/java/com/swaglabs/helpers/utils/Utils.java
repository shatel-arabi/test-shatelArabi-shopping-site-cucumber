package com.swaglabs.helpers.utils;

import com.google.common.base.Strings;
import com.swaglabs.helpers.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

	private static Logger logger = LogManager.getLogger(Utils.class);

	/**
	 * Take screenshot and save to default Selenium download directory path with
	 * file name {testMethodName-timeStamp} Add this method wherever want to capture
	 * the screenshot. ie. on failure or assert.
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
	 * Setting default directory path for Selenium test downloads
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

	/**
	 * Read and return excel sheet data in list of string
	 *
	 * @param fileName
	 * @param sheetName
	 * @return
	 */
	public static List<String> getExcelRowData(String fileName, String sheetName) {
		FileInputStream fileInputStream;
		Workbook workbook = null;
		Cell currentCell;
		List<String> cellContentList = new ArrayList<>();
		String cellContent;

		File filePath = new File("src/test/resources/testdata/" + fileName).getAbsoluteFile(); // File name with
																								// extension, file under
																								// /resources
		if (filePath.exists()) { // So don't get NullPointerException
			try {
				fileInputStream = new FileInputStream(filePath); // Creating open connection with the file

				workbook = new XSSFWorkbook(fileInputStream); // Excel file with .xlsx extension, or use HSSFWorkbook()
																// for .xls
				Sheet sheets = workbook.getSheet(sheetName);
				Iterator<Row> iteratorRow = sheets.iterator();
				cellContentList = new ArrayList<>();

				while (iteratorRow.hasNext()) {
					Row currentRow = iteratorRow.next();
					Iterator<Cell> cellIterator = currentRow.iterator();
					DataFormatter dataFormatter = new DataFormatter(); // POI handling String, Integer data types

					while (cellIterator.hasNext()) {
						currentCell = cellIterator.next();
						cellContent = dataFormatter.formatCellValue(currentCell);
						if (!Strings.isNullOrEmpty(cellContent)) {// Just in-case if cell is null
							cellContentList.add(cellContent.trim());
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return cellContentList;
	}

	/**
	 * Read and return list of string content from PDF file
	 * 
	 * @param filePath
	 * @return
	 */
	public static List<String> getPdfContents(String filePath) {
		PDDocument pdDocument = null;
		List<String> pdfContents = new ArrayList<>();

		File file = new File(filePath.trim()).getAbsoluteFile();
		if (file.exists()) {

			try {
				pdDocument = PDDocument.load(file);
				PDDocumentCatalog pdDocumentCatalog = pdDocument.getDocumentCatalog();
				PDAcroForm pdAcroForm = pdDocumentCatalog.getAcroForm();

				for (PDField pdField : pdAcroForm.getFields()) {
					pdfContents.add(pdField.getValueAsString().trim());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					pdDocument.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			logger.error("Failed - file not found - {}", filePath);
		}
		return pdfContents;
	}

}
