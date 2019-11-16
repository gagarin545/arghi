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
import ru.entity.TitEntity;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class DivisionServiceTest {

    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    private DivisionService devisionService;

    @Resource
    private TitService titService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testDivisionRead() throws Exception {

        DivisionEntity division = new DivisionEntity();

        TitEntity titEntity = new TitEntity();
        titEntity = titService.getByName("ЗМЦТЭТ");
        division.setNameDivision("ШПД г.Златоуст");
        division.setIdcity(3513);
  //      division.setTitEntity( titService.getByName("ЗМЦТЭТ"));
    //    division.setIdDevision(2);
//        devisionService.addDivision(division);

        devisionService.getAll().forEach(ss -> System.out.println( ss.getIdDivision() + ss.getNameDivision()));
    }
}
