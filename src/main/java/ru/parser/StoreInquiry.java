package ru.parser;

import org.openqa.selenium.WebDriver;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.config.DataConfig;
import ru.entity.IncidentEntity;
import ru.service.*;
import ru.utils.InsertRecord;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StoreInquiry {
    static boolean Start = false;

    public void exec(GenericXmlApplicationContext ctx) throws InterruptedException {
        String []str = {
                "#global_fltr_f-j_idt484-",
                "#global_fltr_f-j_idt502-",
                "#global_fltr_f-j_idt505-",
                "#global_fltr_f-j_idt513-",
                "#global_fltr_f-j_idt515-",
                "#global_fltr_f-j_idt521-",
                "#global_fltr_f-j_idt529-",
                "#global_fltr_f-j_idt530-",
                "#global_fltr_f-j_idt532-",
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
        IncidentService incidentService = ctx.getBean("jpaIncident", IncidentService.class);
        DevisionService devisionService = ctx.getBean("jpaDivision", DevisionService.class);
        TechnologyService technologyService = ctx.getBean("jpaTechnology", TechnologyService.class);
        WorkersService workersService = ctx.getBean("jpaWorker", WorkersService.class);
        while (!Start) {
            InsertRecord insert = new InsertRecord();
            InitWeb init = new InitWeb();
            WebDriver driver = init.exec();
            SelectRole selectRole = new SelectRole();
            SelectDay selectDay = new SelectDay();
            OnInvisibleRead onInvisibleRead = new OnInvisibleRead();
            ShutDown shutDown = new ShutDown();
            while ( driver != null) {
                System.out.println(Calendar.getInstance().getTime());
                selectRole.exec(driver, "7");
                for( String s: Mct)
                    insert.exec( onInvisibleRead.OnClick(driver, s), devisionService, technologyService, workersService).forEach( incidentEntity -> incidentService.addIncident(incidentEntity));
                for( String sss: str) selectDay.exec(driver, sss + "1");
                for( String s: Mct)
                    insert.exec( onInvisibleRead.OnClick(driver, s), devisionService, technologyService, workersService).forEach( incidentEntity -> incidentService.addIncident( incidentEntity));
                selectRole.exec(driver, "8");
                for( String s: Mct)
                    insert.exec( onInvisibleRead.OnClick(driver, s), devisionService, technologyService, workersService).forEach( incidentEntity -> incidentService.addIncident( incidentEntity));
                    //System.out.println( "read->" + insert.exec( onInvisibleRead.OnClick(driver, s), devisionService, technologyService, workersService).size());
                for( String sss: str) selectDay.exec(driver, sss + "0");
                for( String s: Mct)
                    insert.exec( onInvisibleRead.OnClick(driver, s), devisionService, technologyService, workersService).forEach( incidentEntity -> incidentService.addIncident( incidentEntity));

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
