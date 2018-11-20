package support;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
    }

    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigate to " + s);
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Navigate back");
    }

    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
    }

    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Navigate forward");
    }

    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("Refresh page");
    }

    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Search for element " + by.toString());
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        if (webElement != null) {
            System.out.println("Found element " + webElement.getTagName());
        }
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Click on element " + webElement.getTagName());
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}

