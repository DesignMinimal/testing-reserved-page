package com.zara.base;

import java.util.List;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

public class TestUtilities extends BaseTest {
	
	/** Get logs from browser console */
	protected List<LogEntry> getBrowserLogs() {
		LogEntries log = driver.manage().logs().get("browser");
		List<LogEntry> logList = log.getAll();
		return logList;
	}
}
