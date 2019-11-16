package ru.parser;

import org.openqa.selenium.WebDriver;
import ru.config.DataConfig;
import ru.utils.MyException;

class ShutDown extends Metod{
    Boolean exec(WebDriver driver) throws MyException {
        Runccs(driver, "#mmf-logout", DataConfig.INTERVAL_L);
        System.out.println("Выход");
        driver.close();
        return false;
    }
}
