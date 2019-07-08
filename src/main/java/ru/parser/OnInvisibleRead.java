package ru.parser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.config.DataConfig;

import java.util.concurrent.TimeUnit;

class OnInvisibleRead {
    String OnClick(WebDriver driver, String str ) throws InterruptedException {
        String script = "var element = arguments[0]; element.style.display='block';";
        WebElement element = driver.findElement(new By.ByCssSelector( str));
        ((JavascriptExecutor)driver).executeScript(script, element);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
        TimeUnit.SECONDS.sleep(DataConfig.INTERVAL);
        return driver.getPageSource();
    }
}
