package ru.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.config.TestDataBaseConfig;
import ru.entity.DivisionEntity;
import ru.entity.IncidentEntity;
import ru.entity.TechnogyEntity;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Timestamp;
import java.util.Calendar;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class IncidentServiceTest {

    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    private IncidentService incidentService;

    @Resource
    private DivisionService devisionService;

    @Resource
    private TechnologyService technologyService;

    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }

    @Test
    public void testTechnologyRead() {


        IncidentEntity incident = new IncidentEntity();

        IncidentEntity incidentEntity =incidentService.getByNumer(8759914);

        DivisionEntity division = devisionService.getByName("ШПД г.Златоуст");
        TechnogyEntity tech = technologyService.getById("PSTN");
       // incident.setAddress("adress");
        incident.setnIncident(Long.parseLong("8759914"));
   //     incident.setClazz("claz");
        //incident.setComment("Засада");


        incident.setService(77740123668L);
        incident.setTypeIncident(1);
        incident.setDivisionEntity( division);
        incident.setTechnogyEntity(tech);
        incident.setTimeClose( new Timestamp(Calendar.getInstance().getTimeInMillis()));

        incidentService.addIncident(incident);
        incidentService.getAll().forEach(ss -> System.out.println(ss.getAddress() + ss.getnIncident() + ss.getService() + ss.getTimeClose()));
    }
}
