package ru.parser;

import org.openqa.selenium.WebDriver;
import ru.config.DataConfig;

class ShutDown extends Metod{
    Boolean exec(WebDriver driver) {
        Runccs(driver, "#mmf-logout", DataConfig.INTERVAL_L);
        System.out.println("Выход");
        driver.close();
        return false;
    }
}
