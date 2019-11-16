package ru.parser;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import ru.config.DataConfig;
import ru.utils.MyException;

import java.util.concurrent.TimeUnit;

class SelectRole extends Metod {
    void exec(WebDriver driver, String command) {
        try {
            Runccs(driver, "#slcts-slct_acc-dsp_f-role_select_label", DataConfig.INTERVAL_L);
            Runccs(driver, "#slcts-slct_acc-dsp_f-role_select_" + command, DataConfig.INTERVAL_L);
            TimeUnit.SECONDS.sleep(DataConfig.INTERVAL);
        } catch (NoSuchElementException | InterruptedException | MyException e) {
            StoreInquiry.Start = false;
            //e.printStackTrace();
        }
    }
}
