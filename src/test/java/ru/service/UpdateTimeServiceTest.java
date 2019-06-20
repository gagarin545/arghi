package ru.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.config.TestDataBaseConfig;
import ru.entity.UpdateTimeEntity;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Timestamp;
import java.util.Calendar;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class UpdateTimeServiceTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    private UpdateTimeService updateTimeService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void UpdateTimeRead(){
        UpdateTimeEntity updatetime = new UpdateTimeEntity();

        // System.out.println(timeupdate);
        updatetime.setTimeUpdate( new Timestamp(Calendar.getInstance().getTimeInMillis()));
        updatetime.setId(1);
        updateTimeService.updateTime( updatetime);

      //  updateTimeService.updateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()), 1);

        updateTimeService.getrecord().forEach(s -> System.out.println(s.getTimeUpdate()));
        System.out.println(updateTimeService.getTime( 1).getTimeUpdate());
    }
}
