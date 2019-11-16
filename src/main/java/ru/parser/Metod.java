package ru.parser;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.utils.MyException;

abstract class Metod {
    void Runccs(WebDriver dr, final String str, long tm) throws MyException {
        try {
            WebElement element = dr.findElement(By.cssSelector(str));
            (new WebDriverWait(dr, tm, 500)).withMessage("-> Элемент не найден.")
                    .until(ExpectedConditions.visibilityOf(element));
            dr.findElement(By.cssSelector(str)).click();
        }catch (NoSuchElementException | TimeoutException | ElementNotInteractableException el) {
            System.out.println("Элемент не найден. Состояние start = " + StoreInquiry.Start );
            throw new MyException("reboot", false);
        }
    }
    void Runid(WebDriver dr, final String str, String val, int tm) {
        WebElement element = dr.findElement(By.id(str));
        (new WebDriverWait(dr, tm)).withMessage("Элемент не найден!!.")
                .until(ExpectedConditions.visibilityOf(element));
        if( val == null)
            dr.findElement(By.id(str)).click();
        else
            dr.findElement(By.id(str)).sendKeys(val);
    }
    void scrollWithOffset(WebDriver driver) {

        String code = "window.scrollBy(0, 50);";
        //((JavascriptExecutor)driver).executeScript(code, webElement, x, y);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 350)", "");
    }
}
