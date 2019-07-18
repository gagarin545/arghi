package ru.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.entity.DevisionEntity;
import ru.entity.IncidentEntity;
import ru.entity.TechnogyEntity;
import ru.entity.WorkersEntity;
import ru.service.CityService;
import ru.service.DevisionService;
import ru.service.TechnologyService;
import ru.service.WorkersService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.lang.System.out;

public class InsertRecord{

    public ArrayList<IncidentEntity> exec(String pars, DevisionService devisionService, TechnologyService technologyService, WorkersService workersService)  {
        String TechData;
        ArrayList<IncidentEntity> incidentall = new ArrayList<>();
        for(Element i0: Jsoup.parse(pars).select("tr") ) {
            Element target = i0.selectFirst("a");
            if( target != null && target.html().length() > 0)  {
                String[] vizit;
                int n = 0;
                IncidentEntity incidentEntity = new IncidentEntity();
                DevisionEntity devisionEntity = new DevisionEntity();
                TechnogyEntity technogyEntity = new TechnogyEntity();
                WorkersEntity workersEntity = new WorkersEntity();
                StringBuilder CommentAll = new StringBuilder();
                out.println(target.html());
                if(target.html().startsWith("Л")) {
                    if( i0.getElementsByAttributeValueContaining("id","clmns-29").html().equals("нет"))
                        TechData = i0.getElementsByAttributeValueContaining("id","clmns-30").html();
                    else
                        TechData = i0.getElementsByAttributeValueContaining("id","clmns-29").html();
                    incidentEntity.setTypeIncident(0);
                }
                else
                    TechData = i0.getElementsByAttributeValueContaining("id","clmns-28").html();
                incidentEntity.setnIncident(Long.parseLong(target.html().split("-\u200B")[1])); // номер заявки
                incidentEntity.setTechData(TechData);   // Тех данные
                Elements span = i0.select("span");
                for(int count = 1 ; count < span.size() ; count++ ) {
                    switch (++n) {
                        case 1:
                            if(span.get(count).html().toUpperCase().contains("ВИДЕОНАБЛЮДЕНИЕ")) {
                                incidentEntity.setIdCity(Integer.parseInt(span.get(count).html().split("ВИДЕОНАБЛЮДЕНИЕ")[0]));
                                incidentEntity.setService(Long.parseLong( span.get(count).html().split("ВИДЕОНАБЛЮДЕНИЕ")[0] + span.get(count).html().split("ВИДЕОНАБЛЮДЕНИЕ")[1].substring(2)));
                                continue;
                            }
                            if( span.get(count).html().toUpperCase().contains("IMS")) {
                                incidentEntity.setIdCity(Integer.parseInt(span.get(count).html().split("IMS")[0]));
                                incidentEntity.setService(Long.parseLong( span.get(count).html().split("IMS")[0] + span.get(count).html().split("IMS")[1]));
                                continue;
                            }
                            if( span.get(count).html().toUpperCase().contains("СПД")) {
                                incidentEntity.setIdCity(Integer.parseInt(span.get(count).html().split("СПД")[0]));
                                incidentEntity.setService(Long.parseLong( "77" + span.get(count).html().split("СПД")[1]));
                                continue;
                            }
                            if( span.get(count).html().toUpperCase().contains("IP-TV SMART TUBE")) {
                                incidentEntity.setIdCity(Integer.parseInt(span.get(count).html().split("IP-TV SMART TUBE")[0]));
                                incidentEntity.setService(Long.parseLong( "77" + span.get(count).html().split("IP-TV SMART TUBE")[1]));
                                continue;
                            }
                            incidentEntity.setIdCity(Integer.parseInt(span.get(count).html().substring(0, 5)));
                            incidentEntity.setService(Integer.parseInt(span.get(count).html().substring( 5)));
                            continue;
                        case 2:
                            incidentEntity.setDeclared(span.get(count).html());
                            continue;
                        case 4:
                            if (span.get(count).childNodeSize() > 1)
                                incidentEntity.setControlTerm(span.get(count).childNode(0) + span.get(count++ + 1).html().replace("&nbsp;", ""));
                            continue;
                        case 5:
                        case 6:
                            if (span.get(count).childNodeSize() > 1)
                                incidentEntity.setControlTermSla(span.get(count).childNode(0) + span.get(count++ + 1).html().replace("&nbsp;", ""));
                            continue;
                        case 7:
                            if (span.get(count).childNodeSize() > 1)
                                incidentEntity.setControlTermTask(span.get(count).childNode(0) + span.get(count++ + 1).html().replace("&nbsp;", ""));
                            continue;
                        case 9:
                            if(span.get(count).html().toUpperCase().equals("ДА"))
                                incidentEntity.setRepet( 1);
                            continue;
                        case 10:
                           // out.println(n + " лицо->" + span.get(count).html());
                            incidentEntity.setClazz(span.get(count).html());
                            continue;
                        case 15:
                            //out.println("технология ->" +span.get(count).html());
                            if( technologyService.getById( span.get(count).html()) == null) {
                                technogyEntity.setMameTechnology( span.get(count).html());
                                technologyService.addTechnology( technogyEntity);
                            }
                            incidentEntity.setTechnogyEntity( technologyService.getById( span.get(count).html()));
                            continue;
                        case 17:
                            if( devisionService.getByName(span.get(count).html()) == null) {
                                devisionEntity.setNamedevision( span.get(count).html());
                                devisionEntity.setIdcity( incidentEntity.getIdCity());
                                devisionService.addDivision( devisionEntity);
                            }
                            incidentEntity.setDivisionEntity( devisionService.getByName(span.get(count).html()));
                            //out.println(n + " отдел->" + span.get(count).html());
                            continue;
                        case 18:
                            while (count < span.size())
                                if (span.get(count).html().startsWith("с ") && span.get(count).html().contains(" до "))
                                    break;
                                else
                                    count++;
                            //out.println(n + " раб ->"  +  span.get(count -1).html()); //workers
                            if(workersService.getByName(span.get(count -1).html()) == null) {
                                workersEntity.setName( span.get(count -1).html());
                                workersService.addWorker( workersEntity);
                            }
                            incidentEntity.setWorkersEntity( workersService.getByName(span.get(count -1).html()));

                            //System.out.println(n + "->" + span.get(count).html());
                            vizit = span.get(count).html().replace('.','-').split(" ");
                            incidentEntity.setDecisionTime(Timestamp.valueOf(vizit[4].split("-")[2] + '-' + vizit[4].split("-")[1] + '-' + vizit[4].split("-")[0] + ' ' + vizit[3] + ":00"));
                             continue;
                        case 20:
                            //out.println(n + " имя ->"  +  span.get(count).html());
                            incidentEntity.setNameClient( span.get(count).html());      // Имя клиента
                            continue;
                        case 21:
                           // out.println(n + " адрес ->"  +  span.get(count).html());
                            incidentEntity.setAddress( span.get(count).html());         // Адрес
                            continue;
                        case 22:
                            incidentEntity.setRoom( span.get(count).html());           // номер помещения
                           // out.println(n + " пом. ->"  +  span.get(count).html());
                            continue;
                        case 23:
                            //out.println(n + " тел ->"  +  span.get(count).html());
                             try {
                                 Long.parseLong(span.get(count).html());
                            } catch (Exception e) { continue;   }
                            incidentEntity.setPhone( Long.parseLong(span.get(count).html()));   // Номер телефона
                            continue;
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            if( !span.get(count).html().equals(TechData) && !span.get(count).html().equals("нет"))
                                CommentAll.append(span.get(count).html()).append(" ");
                            continue;
                        default:
                            if (span.get(count).childNodeSize() > 1)    count++;
                               //out.println(n + "+->" +count + "---->" + span.get(count).childNode(0) + span.get(count++ + 1).html().replace("&nbsp;", ""));
                           // else
                             //   out.println(n + "-->" +count + "->" + span.get(count).html());
                    }
                }
                incidentEntity.setTimeClose( new Timestamp(Calendar.getInstance().getTimeInMillis()));
                incidentEntity.setComment(String.valueOf(CommentAll));
                incidentall.add(incidentEntity);
            }
        }
        out.println( "Записей обработано ->" + incidentall.size());
        return incidentall;
    }
}
