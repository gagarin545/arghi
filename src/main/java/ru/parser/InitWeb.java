package ru.parser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.config.DataConfig;
import ru.utils.MyException;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

class InitWeb extends Metod {
    private WebDriver driver;
    WebDriver exec() throws InterruptedException, MyException {
        int interval = 3;
        String url_name = "http://argusweb.ur.rt.ru:8080/argus";
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty("webdriver.gecko.driver", DataConfig.FIREFOX);
        driver =new FirefoxDriver();
        driver.get(url_name);
        Runid(driver,"login_form-username", DataConfig.LOGIN, DataConfig.INTERVAL_L);
        Runid(driver,"login_form-password", DataConfig.PASSWORD, DataConfig.INTERVAL_L);
        Runid(driver,"login_form-submit",null, DataConfig.INTERVAL_L);
        TimeUnit.SECONDS.sleep(interval);
        Runccs(driver,"li.ui-menu-parent:nth-child(2)", DataConfig.INTERVAL_L);
        out.println("Задачи");
        TimeUnit.SECONDS.sleep(interval);
        Runccs(driver,"li.ui-menu-parent:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)", DataConfig.INTERVAL_L);
        out.println("список задач");
        TimeUnit.SECONDS.sleep(interval);
        Runccs(driver,"#slcts-slct_acc-dsp_f_title > span:nth-child(1)", DataConfig.INTERVAL_L);
        out.println("участки");
        TimeUnit.SECONDS.sleep(interval);
        return driver;
    }
}
