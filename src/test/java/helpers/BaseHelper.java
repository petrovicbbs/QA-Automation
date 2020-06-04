package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseHelper {
    protected static WebDriver driver = new ChromeDriver();
    protected static WebDriverWait wdWait = new WebDriverWait(driver, 20);
    protected static void scrollToElement(WebElement element){
        //WebDriver elemDriver = ((RemoteWebElement)element).getWrappedDriver();

        System.out.println("Scrolling to element to be clicked");
        try
        {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            if (null != element)
            {
                je.executeScript("arguments[0].scrollIntoView(true);", element);
            } else
            {
                // scrolling to top
                je.executeScript("window.scrollTo(0,0)");
            }
        } catch (Exception ex)
        {
            System.out.println("FAILED scrolling to " + element.toString());
        }
    }
    public static WebElement returnElementAttValue(String attributeName, String attributeValue){
        String selector = "[" + attributeName + "=" + attributeValue + "]";
        WebElement element = driver.findElement(By.cssSelector(selector));
        return element;
    }
    public static List<WebElement> returnElementAttValueList(String attributeName, String attributeValue){
        String selector = "[" + attributeName + "=" + attributeValue + "]";
        List<WebElement> elements = driver.findElements(By.cssSelector(selector));

        return elements;
    }
    public static WebElement returnElementAttValueText(String searchTerm, String attributeName, String attributeValue){
        String selector = "[" + attributeName + "=" + attributeValue + "]";
        List<WebElement> elements = driver.findElements(By.cssSelector(selector));
        WebElement selectedCategory = null;
        for (WebElement element : elements)
        {
            if (element.getText().equals(searchTerm))
            {
                selectedCategory = element;
                break;
            }
        }
        return selectedCategory;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Wait for some period of time
    public static void waitForIt(int syncWait) throws InterruptedException {
        // Waiting to refresh results
        synchronized (driver) {
            // >=800ms
            driver.wait(syncWait);
        }
    }
    //Search, Wait, Select WebElement By
    public static WebElement SWS(String attribute,String attributeData){
        WebElement element = null;

        switch (attribute) {
            case "id":  wdWait.until(ExpectedConditions.elementToBeClickable(By.id(attributeData)));
                        element = driver.findElement(By.id(attributeData));
                        break;
            case "xpath":   wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath(attributeData)));
                            element = driver.findElement(By.xpath(attributeData));
                            break;
            case "className":   wdWait.until(ExpectedConditions.elementToBeClickable(By.className(attributeData)));
                                element = driver.findElement(By.className(attributeData));
                                break;
            case "tagName": wdWait.until(ExpectedConditions.elementToBeClickable(By.tagName(attributeData)));
                            element = driver.findElement(By.tagName(attributeData));
                            break;
            case "cssSelector": wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(attributeData)));
                                element = driver.findElement(By.cssSelector(attributeData));
                                break;
            case "linkText":wdWait.until(ExpectedConditions.elementToBeClickable(By.linkText(attributeData)));
                            element = driver.findElement(By.linkText(attributeData));
                            break;
            case "name":wdWait.until(ExpectedConditions.elementToBeClickable(By.name(attributeData)));
                        element = driver.findElement(By.name(attributeData));
                        break;
        }
        return element;
    }
    public static WebElement SWS(String attribute,String attributeData, WebElement parent){
        WebElement element = null;

        switch (attribute)
        {
            case "id":  wdWait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id(attributeData))));
                        element = parent.findElement(By.id(attributeData));
                        break;
            case "xpath":   wdWait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.xpath(attributeData))));
                            element = parent.findElement(By.xpath(attributeData));
                            break;
            case "className":   wdWait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.className(attributeData))));
                                element = parent.findElement(By.className(attributeData));
                                break;
            case "tagName": wdWait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.tagName(attributeData))));
                            element = parent.findElement(By.tagName(attributeData));
                            break;
            case "cssSelector": wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(attributeData)));
                                element = parent.findElement(By.cssSelector(attributeData));
                                break;
            case "linkText":wdWait.until(ExpectedConditions.elementToBeClickable(By.linkText(attributeData)));
                            element = parent.findElement(By.linkText(attributeData));
                            break;
            case "name":wdWait.until(ExpectedConditions.elementToBeClickable(By.name(attributeData)));
                        element = parent.findElement(By.name(attributeData));
                        break;
        }
        return element;
    }
    //Make list of WebElements By
    public static List<WebElement> ToListOfWEBy(String attribute,String attributeData){
        List<WebElement> listOfElements=null;

        switch (attribute)
        {
            case "id":  wdWait.until(ExpectedConditions.elementToBeClickable(By.id(attributeData)));
                        listOfElements = driver.findElements(By.id(attributeData));
                        break;
            case "xpath":   wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath(attributeData)));
                            listOfElements = driver.findElements(By.xpath(attributeData));
                            break;
            case "className":   wdWait.until(ExpectedConditions.elementToBeClickable(By.className(attributeData)));
                                listOfElements = driver.findElements(By.className(attributeData));
                                break;
            case "tagName": wdWait.until(ExpectedConditions.elementToBeClickable(By.tagName(attributeData)));
                            listOfElements = driver.findElements(By.tagName(attributeData));
                            break;
            case "cssSelector": wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(attributeData)));
                                listOfElements = driver.findElements(By.cssSelector(attributeData));
                                break;
            case "linkText":wdWait.until(ExpectedConditions.elementToBeClickable(By.linkText(attributeData)));
                            listOfElements = driver.findElements(By.linkText(attributeData));
                            break;
            case "name":wdWait.until(ExpectedConditions.elementToBeClickable(By.name(attributeData)));
                        listOfElements = driver.findElements(By.name(attributeData));
                        break;
        }
        return listOfElements;
    }
    public static List<WebElement> ToListOfWEBy(String attr,String attrData, WebElement parent){
        List<WebElement> listOfElements=null;

        wdWait.until(ExpectedConditions.elementToBeClickable(parent));

        switch (attr)
        {
            case "id":  listOfElements = parent.findElements(By.id(attrData)); break;
            case "xpath":   listOfElements = parent.findElements(By.xpath(attrData)); break;
            case "className":   listOfElements = parent.findElements(By.className(attrData)); break;
            case "tagName": listOfElements = parent.findElements(By.tagName(attrData)); break;
            case "cssSelector": listOfElements = parent.findElements(By.cssSelector(attrData)); break;
            case "linkText":listOfElements = parent.findElements(By.linkText(attrData)); break;
            case "name":listOfElements = parent.findElements(By.name(attrData)); break;
        }
        return listOfElements;
    }
    //Making list of WebElements and counting is it bigger than 1
    public static boolean isExists(String attribute,String attributeData){
        boolean result=false;

        switch (attribute) {
            case "id":  result = driver.findElements(By.id(attributeData)).size()!=0; break;
            case "xpath":   result = driver.findElements(By.xpath(attributeData)).size()!=0; break;
            case "className":   result = driver.findElements(By.className(attributeData)).size()!=0; break;
            case "tagName": result = driver.findElements(By.tagName(attributeData)).size()!=0; break;
            case "cssSelector": result = driver.findElements(By.cssSelector(attributeData)).size()!=0; break;
            case "linkText":result = driver.findElements(By.linkText(attributeData)).size()!=0; break;
            case "name":result = driver.findElements(By.name(attributeData)).size()!=0; break;
        }
        return result;
    }
    public static boolean isExists(String attribute,String attributeData, WebElement parent){
        boolean result=false;

        switch (attribute) {
            case "id":  result = parent.findElements(By.id(attributeData)).size()!=0; break;
            case "xpath":   result = parent.findElements(By.xpath(attributeData)).size()!=0; break;
            case "className":   result = parent.findElements(By.className(attributeData)).size()!=0; break;
            case "tagName": result = parent.findElements(By.tagName(attributeData)).size()!=0; break;
            case "cssSelector": result = parent.findElements(By.cssSelector(attributeData)).size()!=0; break;
            case "linkText":result = parent.findElements(By.linkText(attributeData)).size()!=0; break;
            case "name":result = parent.findElements(By.name(attributeData)).size()!=0; break;
        }
        return result;
    }
}


