package org.example;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
// import io.appium.java_client.android.AndroidElement;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest extends BrowserStackJunitTest{

    @Test
    @Tag("FirstTest")
    void test() throws Exception, InterruptedException {
        System.out.println("First test started");
        WebElement searchElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Search Wikipedia")));
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

        searchElement.click();
        WebElement insertTextElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);

        List<WebElement> allProductsName = driver.findElements(AppiumBy.className("android.widget.TextView"));
        assertTrue(allProductsName.size() > 0);
        System.out.println("First test ended");
        if (true) {
            throw new Exception("First test failed");
        }
    }

    @Test
    @Tag("Skippedtest")
    @Disabled
    void test2() {
        System.out.println("Skipped test started");
        assertTrue(false);
        System.out.println("Skipped test ended");
    }
}
