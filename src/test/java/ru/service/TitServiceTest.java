package ru.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.entity.TitEntity;
import ru.config.TestDataBaseConfig;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class TitServiceTest {

    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    private TitService titService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testTitRead() throws Exception {
        //bankService.addBank(BankUtil.createBank());
        List<TitEntity> tit = titService.getAll();
        tit.forEach(ss -> System.out.println( ss.getIdTit() + ss.getNameTit()));

        System.out.println(titService.getByName("ЗМЦТЭТ").getIdTit());


    }
}
