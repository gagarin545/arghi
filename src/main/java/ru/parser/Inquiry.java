package ru.parser;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.service.IncidentService;
import ru.utils.InsertRecord;


import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;


abstract class Inquiry{
    private static WebDriver driver;
    private static int tmlong = config.INTERVAL_L, tmout = config.INTERVAL;
    static SimpleDateFormat formatTime = new SimpleDateFormat("[HH:mm:ss]");
    public IncidentService incidentService;

    private final String[] Mct = {
        "#slcts-slct_acc-dsp_f-tree-0_0-txt_n",
        "#slcts-slct_acc-dsp_f-tree-0_1-txt_n",
        "#slcts-slct_acc-dsp_f-tree-0_2-txt_n",
        "#slcts-slct_acc-dsp_f-tree-0_3-txt_n",
        "#slcts-slct_acc-dsp_f-tree-0_4-txt_n",
        "#slcts-slct_acc-dsp_f-tree-0_5-txt_n",
        "#slcts-slct_acc-dsp_f-tree-0_6-txt_n"
    };


    Boolean init() throws InterruptedException {
        int interval = 3;
        String url_name = "http://argusweb.ur.rt.ru:8080/argus";

        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty("webdriver.gecko.driver", config.FIREFOX);

        driver =new FirefoxDriver();
        driver.get(url_name);

        Runid(driver,"login_form-username", config.LOGIN, tmlong );
        Runid(driver,"login_form-password", config.PASSWORD, tmlong );
        Runid(driver,"login_form-submit",null,  tmlong );
        TimeUnit.SECONDS.sleep(interval);


        Runccs(driver,"li.ui-menu-parent:nth-child(2)",tmlong);
        out.println("Задачи");
        TimeUnit.SECONDS.sleep(interval);

        Runccs(driver,"li.ui-menu-parent:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)",tmlong);
        out.println("список задач");
        TimeUnit.SECONDS.sleep(interval);
        //TimeUnit.SECONDS.sleep(tmout);

        Runccs(driver,"#slcts-slct_acc-dsp_f_title > span:nth-child(1)",tmlong);
        out.println("участки");
        TimeUnit.SECONDS.sleep(interval);

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();
        incidentService = ctx.getBean("jpaIncident", IncidentService.class);

        return true;
    }


    static Boolean shutdriver() {

        Runccs(driver,"#mmf-logout", tmlong);
        out.println("Выход");
        driver.close();
        return false;
    }


    Boolean ReadLine()  {

        Runccs(driver,"#slcts-slct_acc-dsp_f-role_select_label", tmlong);

        Runccs(driver,"#slcts-slct_acc-dsp_f-role_select_7", tmlong);
        try {
            TimeUnit.SECONDS.sleep(config.INTERVAL_L);

            for(String s : Mct)
                InsertRecord.InsertIncident(makeMct(s));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        out.println("Линия сегодня");
        return true;
    }


    Boolean ReadLine_Next() {
        String str = "";

        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt534-1-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt534-1-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt502-1-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt502-1-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt484-1-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt484-1-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt505-1-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt505-1-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt515-1-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt515-1-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt541-1-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt541-1-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt513-1-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt513-1-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt521-1-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt521-1-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt529-1-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt529-1-status_value > div:nth-child(2) > span:nth-child(1)";
        System.out.println(str);

        Runccs(driver, str, tmlong);
        try {
            TimeUnit.SECONDS.sleep(config.INTERVAL_L);

            for(String s : Mct)
                InsertRecord.InsertIncident( makeMct(s));

        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        out.println("линия завтра");
        return true;
       // return str;
    }

    Boolean ReadShpd()  {

        try {
            Runccs(driver,"#slcts-slct_acc-dsp_f-role_select_label", tmlong);
            TimeUnit.SECONDS.sleep(tmout);

            Runccs(driver,"#slcts-slct_acc-dsp_f-role_select_8", tmlong);
            TimeUnit.SECONDS.sleep(config.INTERVAL_L);

            for(String s : Mct)
                InsertRecord.InsertIncident( makeMct(s));

        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        out.println("ШПД завтра");
        return true;
    }

    Boolean ReadShpd_today()  {
        String str = null;

        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt534-0-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt534-0-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt502-0-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt502-0-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt484-0-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt484-0-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt505-0-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt505-0-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt515-0-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt515-0-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt513-0-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt513eee-0-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt521-0-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt521-0-status_value > div:nth-child(2) > span:nth-child(1)";
        if(driver.findElements(By.cssSelector("#global_fltr_f-j_idt529-0-status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0)
            str = "#global_fltr_f-j_idt529-0-status_value > div:nth-child(2) > span:nth-child(1)";

        System.out.println(str);


        try {
            Runccs(driver, str, tmlong);
            TimeUnit.SECONDS.sleep(config.INTERVAL_L);

            for(String s : Mct)
                InsertRecord.InsertIncident( makeMct(s));
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        out.println("ШПД сегодня");

        return true;
    }

    private void makeElementVisibleByJavascript(final WebElement element) {
        String script = "var element = arguments[0]; element.style.display='block';";

        ((JavascriptExecutor)driver).executeScript(script, element);
    }

    private String makeMct(String str) throws InterruptedException {
        WebElement element=driver.findElement(new By.ByCssSelector( str));

        makeElementVisibleByJavascript( element);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);

        TimeUnit.SECONDS.sleep(tmlong);
        return driver.getPageSource();
    }

    private static void Runid(WebDriver dr, final String str, String val, int tm) {

        WebElement element = dr.findElement(By.id(str));
        (new WebDriverWait(dr, tm)).withMessage("Элемент не найден.")
                .until(ExpectedConditions.visibilityOf(element));

        if( val == null)
            dr.findElement(By.id(str)).click();
        else
            dr.findElement(By.id(str)).sendKeys(val);
    }

    private static void Runccs(WebDriver dr, final String str, long tm)  {

        try {
            WebElement element = dr.findElement(By.cssSelector(str));
            (new WebDriverWait(dr, tm, 500)).withMessage("Элемент не найден.")
                    .until(ExpectedConditions.visibilityOf(element));

            dr.findElement(By.cssSelector(str)).click();
        }catch ( ElementNotInteractableException el) {
            StoreInquiry.Start = false;
            System.out.println("Элемент не найден. Состояние start = " + StoreInquiry.Start );
        }
    }

}

