package com.aescis.page.functions.spark;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.aep.CustomerCloneUtilityLocators;
import com.aescis.page.locators.spark.MeterLoadPageLocators;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MeterLoadPageObject extends AbstractBasePage {
    private final MeterLoadPageLocators meterLoadPageLocators;
    private final CustomerCloneUtilityLocators customerCloneUtilityLocators;

    @Autowired
    public MeterLoadPageObject(final WebDriver driver) {
        super(driver);
        meterLoadPageLocators = PageFactory.initElements(driver, MeterLoadPageLocators.class);
        customerCloneUtilityLocators = PageFactory.initElements(driver, CustomerCloneUtilityLocators.class);
    }

    static private Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyPageLoaded() {
        assertTextIsVisible(meterLoadPageLocators.heading,
                testProps().getProperty("meterLoadPage.verification"),
                "METER LOAD PROFILE");
    }

    public void verifyCountOfRows(int count) {
        assertCountOfElements(meterLoadPageLocators.rows,
                testProps().getProperty("meterRowCount.verification"), count);
    }

    public void verifyNoRowDisplayedForInvalidMeterId() {
        assertTextIsVisible(customerCloneUtilityLocators.cloneSuccessMessage,
                testProps().getProperty("meterLoadPage.verification"),
                "Meter not found");
    }
}
