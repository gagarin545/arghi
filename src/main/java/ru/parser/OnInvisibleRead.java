package ru.parser;

import org.openqa.selenium.*;
import ru.config.DataConfig;
import ru.utils.MyException;

import java.util.concurrent.TimeUnit;

class OnInvisibleRead {
    String OnClick(WebDriver driver, String str ) throws MyException {
        try {
            String script = "var element = arguments[0]; element.style.display='block';";
            WebElement element = driver.findElement(new By.ByCssSelector( str));
            ((JavascriptExecutor)driver).executeScript(script, element);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();",element);
            try {
                TimeUnit.SECONDS.sleep(DataConfig.INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch ( NoSuchElementException e) {
            System.out.println("Error -> OnVisible");
            StoreInquiry.Start = false;
            throw new MyException("reboot", false);
        }
        return driver.getPageSource();
    }
}
