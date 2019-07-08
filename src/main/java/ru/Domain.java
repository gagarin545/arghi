package ru;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.entity.CityEntity;
import ru.entity.IncidentEntity;
import ru.entity.TitEntity;
import ru.service.CityService;
import ru.service.IncidentService;
import ru.service.TitService;

import java.util.List;


public class Domain {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();


        TitService titService = ctx.getBean("jpaTit", TitService.class);
        CityService cityService = ctx.getBean("jpaCity", CityService.class);
        IncidentService incidentService = ctx.getBean("jpaIncident", IncidentService.class);

        List<IncidentEntity> incident = incidentService.getAll();
        incident.forEach(f -> System.out.println(f.getnIncident()));

        List<CityEntity> city = cityService.getAll();
        city.forEach(f -> System.out.println(f.getNamecity()) );

        List<TitEntity> titEntities = titService.getAll();
        titEntities.forEach(f-> System.out.println(f.getNameTit()));


    }
}
