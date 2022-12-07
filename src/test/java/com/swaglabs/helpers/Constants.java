package com.swaglabs.helpers;

import org.apache.commons.lang3.SystemUtils;

public class Constants {

	public static final int TIMEOUT_SECONDS_THIRTY = 30;
	public static final int TIMEOUT_SECONDS_TEN = 10;
	public static final int TIMEOUT_SECONDS_FIVE = 5;

	public static final String DEFAULT_ENVIRONMENT = "test";
	public static final String DEFAULT_DIRECTORY = SystemUtils.IS_OS_WINDOWS ? "C:/selenium-tests-downloads/"
			: System.getProperty("user.home") + "/selenium-tests-downloads/";

}