package ru.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.config.TestDataBaseConfig;
import ru.entity.WorkersEntity;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class WorkersServiceTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    private WorkersService workersService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testWorkersRead() throws Exception {
        WorkersEntity worker = new WorkersEntity();
        worker.setName("Юра");
        int [] i = { 1,2,3};
        worker.setIddivision(i);
        workersService.addWorker(worker);
        workersService.getAll().forEach(ss -> System.out.println( Arrays.toString(ss.getIddivision()) + ss.getIdworker() + ss.getImei() + ss.getName() ));
    }
}
