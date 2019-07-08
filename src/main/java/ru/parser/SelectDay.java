package ru.parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.config.DataConfig;

import java.util.concurrent.TimeUnit;

class SelectDay extends Metod{
    void exec(WebDriver driver, String str) throws InterruptedException {
        if(driver.findElements(By.cssSelector(str + "-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0) {
            Runccs(driver, str + "-status_value > div:nth-child(2) > span:nth-child(1)", DataConfig.INTERVAL_L);
            TimeUnit.SECONDS.sleep(DataConfig.INTERVAL);
        }
    }
}
