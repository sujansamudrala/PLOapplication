package com.start.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.start.base.TestBase;

public class TestUtil extends TestBase {

	public static String screenshotName;
	public static void captureScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		FileUtils.copyFile(scrFile,
				new File("D:\\test screenshots" + screenshotName));

				//new File("C:\\Users\\139511\\eclipse-workspace\\ImplimentationSite\\test-output\\extentreports\\" + screenshotName));

	}
}
