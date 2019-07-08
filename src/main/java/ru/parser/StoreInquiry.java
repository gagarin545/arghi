package ru.parser;

import org.openqa.selenium.WebDriver;
import ru.config.DataConfig;
import ru.utils.InsertRecord;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class StoreInquiry {
    static boolean Start = false;
    void inquiryOrder() throws InterruptedException, ExecutionException, IOException {
        String []str = {
                "#global_fltr_f-j_idt484-",
                "#global_fltr_f-j_idt502-",
                "#global_fltr_f-j_idt505-",
                "#global_fltr_f-j_idt513-",
                "#global_fltr_f-j_idt515-",
                "#global_fltr_f-j_idt521-",
                "#global_fltr_f-j_idt529-",
                "#global_fltr_f-j_idt530-",
                "#global_fltr_f-j_idt534-",
                "#global_fltr_f-j_idt541-"
        };
        final String[] Mct = {
                "#slcts-slct_acc-dsp_f-tree-0_0-txt_n",
                "#slcts-slct_acc-dsp_f-tree-0_1-txt_n",
                "#slcts-slct_acc-dsp_f-tree-0_2-txt_n",
                "#slcts-slct_acc-dsp_f-tree-0_3-txt_n",
                "#slcts-slct_acc-dsp_f-tree-0_4-txt_n",
                "#slcts-slct_acc-dsp_f-tree-0_5-txt_n",
                "#slcts-slct_acc-dsp_f-tree-0_6-txt_n"
        };

        String ss;


        while (!Start) {
            InsertRecord insert = new InsertRecord();
            InitWeb init = new InitWeb();
            WebDriver driver = init.exec();
            SelectRole selectRole = new SelectRole();
            SelectDay selectDay = new SelectDay();
            OnInvisibleRead onInvisibleRead = new OnInvisibleRead();
            ShutDown shutDown = new ShutDown();
            while ( driver != null) {
                //String s = "#slcts-slct_acc-dsp_f-tree-0-txt_n";
                System.out.println(Calendar.getInstance().getTime());
                selectRole.exec(driver, "7");
                for( String s: Mct)
                    insert.exec( onInvisibleRead.OnClick(driver, s));
                for( String sss: str) selectDay.exec(driver, sss + "1");
             //   for( String s: Mct)   #global_fltr_f-j_idt530-1-status_value > div:nth-child(2) > span:nth-child(1)
           //         ss = onInvisibleRead.OnClick(driver, s);
                selectRole.exec(driver, "8");
       //         for( String s: Mct)
          //          ss = onInvisibleRead.OnClick(driver, s);
                for( String sss: str) selectDay.exec(driver, sss + "0");
     //           for( String s: Mct)
           //         ss = onInvisibleRead.OnClick(driver, s);

                Start = calendar_read.func(DataConfig.START, DataConfig.STOP);
                System.out.println("Состояние=" + Start + " Пауза=" + DataConfig.INTERVAL);
                TimeUnit.MINUTES.sleep( DataConfig.INTERVAL);
            }
            Start = shutDown.exec(driver);
            System.out.println("Stop!");
            while (!calendar_read.func( DataConfig.START, DataConfig.STOP));
        }
    }

    private test<Boolean, Integer> calendar_read = (t1, t2) -> {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY) > t1 & calendar.get(Calendar.HOUR_OF_DAY) < t2 ;
    };
}
