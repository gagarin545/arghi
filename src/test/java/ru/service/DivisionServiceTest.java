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
    private DivisionService divisionService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testDivisionRead() throws Exception {

     //   DivisionEntity division = new DivisionEntity();
      //  division.setMameDivison("ШПД г.Златоуст");

      //  divisionService.addDivision(division);

        divisionService.getAll().forEach(ss -> System.out.println( ss.getIdDevision() + ss.getNamedivision()));
    }
}
