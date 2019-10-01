//=====================================================================================================================
// Copyright (c) 2017. Aurea Software, Inc. All Rights Reserved.
//
// You are hereby placed on notice that the software, its related technology and services may be covered by one or
// more United States ("US") and non-US patents. A listing that associates patented and patent-pending products
// included in the software, software updates, their related technology and services with one or more patent numbers
// is available for you and the general public's access at www.aurea.com/legal/ (the "Patent Notice") without charge.
// The association of products-to-patent numbers at the Patent Notice may not be an exclusive listing of associations,
// and other unlisted patents or pending patents may also be associated with the products. Likewise, the patents or
// pending patents may also be associated with unlisted products. You agree to regularly review the products-to-patent
// number(s) association at the Patent Notice to check for updates.
//=====================================================================================================================

package com.aescis.lib;

import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.helper.ScumberException;

/** <!-- ========================================================================================================== -->
 * Factory to create the correct web driver instance based on the environment setup.
 *
 * @lastrev fixXXXXX - new class
 * <!-- -------------------------------------------------------------------------------------------------------- --> */

public final class WebDriverFactory
{
	private final static Logger Log = Logger.getLogger(WebDriverFactory.class.getName());

	private WebDriverFactory()
	{
		// Should not be invoked directly.
	}

	public static WebDriver createWebDriver()
		throws ScumberException
	{
		final Properties props = PropertiesLoader.getInstance().load("browser.properties");

		final String browser = System.getProperty("browser", props.getProperty("browser"));
		//browser = StringUtils.trimToEmpty(browser);

		return createWebDriver(browser);
	}

	public static WebDriver createWebDriver(final String browser)
		throws ScumberException
	{
		Log.info("Creating browser instance: " + browser);

		switch (browser)
		{
			case "ie":
				return createIeWebDriver();

			case "chrome":
				return createChromeWebDriver();

			case "firefox":
				return createFirefoxWebDriver();
		}

		throw new ScumberException("Unknown browser type: " + browser);
	}

	private static WebDriver createIeWebDriver()
	{
		System.setProperty("webdriver.ie.driver", "src/test/java/resource/IEDriverServer.exe");

		final DesiredCapabilities caps = DesiredCapabilities.internetExplorer();

		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		caps.setJavascriptEnabled(true);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
		caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);

		return new InternetExplorerDriver(caps);
	}

	private static WebDriver createChromeWebDriver()
	{
		final String nativeOS = System.getProperty("os.name").toLowerCase();
		if (nativeOS.indexOf("linux") >= 0)
		{
			System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/linux/chromedriverLinux");
		}
		else if (nativeOS.indexOf("mac") >= 0)
		{
			System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/osx/chromedriver");
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/windows/chromedriver.exe");
		}

		final ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.addArguments("--no-sandbox");

		return new ChromeDriver(options);
	}

	private static WebDriver createFirefoxWebDriver()
	{
		/*System.setProperty("webdriver.gecko.driver", "src/test/java/resource/geckodriver.exe");
		final DesiredCapabilities legacyCapabilities = DesiredCapabilities.firefox();
		legacyCapabilities.setCapability("marionette", false);
		final WebDriver driver = new FirefoxDriver(legacyCapabilities.firefox());
		return driver;*/

		//For switching to Selenium version : 2.53.0 uncomment this and comment above lines
		return new FirefoxDriver(DesiredCapabilities.firefox());
	}
}
