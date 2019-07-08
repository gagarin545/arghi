package ru.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.entity.IncidentEntity;
import java.sql.Timestamp;

import static java.lang.System.out;

public class InsertRecord{

    public InsertRecord() { }

    public void exec(String pars)  {
        int record = 0;
        String TechData;
        for(Element i0: Jsoup.parse(pars).select("tr") ) {
            Element target = i0.selectFirst("a");

            if( target != null && target.html().length() > 0)  {
                int n = 0;
                IncidentEntity incidentEntity = new IncidentEntity();
                StringBuilder CommentAll = new StringBuilder();

                if(target.html().startsWith("Л")) {
                    if( i0.getElementsByAttributeValueContaining("id","clmns-29").html().equals("нет"))
                        TechData = i0.getElementsByAttributeValueContaining("id","clmns-30").html();
                    else
                        TechData = i0.getElementsByAttributeValueContaining("id","clmns-29").html();
                }
                else
                    TechData = i0.getElementsByAttributeValueContaining("id","clmns-28").html();

                incidentEntity.setnIncident(Integer.parseInt(target.html().split("-")[1])); // номер заявки
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
                                incidentEntity.setService(Long.parseLong( span.get(count).html().split("СПД")[0] + span.get(count).html().split("СПД")[1]));
                                continue;
                            }
                            incidentEntity.setIdCity(Integer.parseInt(span.get(count).html().substring(0, 5)));
                            incidentEntity.setService(Integer.parseInt(span.get(count).html().substring( 5)));
                            continue;
                        case 2:
                            incidentEntity.setDeclared(span.get(count).html());
                            continue;
                        case 4:
                        case 7:
                            if (span.get(count).childNodeSize() > 1)
                                incidentEntity.setControlTerm(span.get(count).childNode(0) + span.get(count++ + 1).html().replace("&nbsp;", ""));
                            else
                                incidentEntity.setControlTerm(span.get(count).html());
                            continue;
                        case 5:
                        case 6:
                            if (span.get(count).childNodeSize() > 1)
                                incidentEntity.setControlTermSla(span.get(count).childNode(0) + span.get(count++ + 1).html().replace("&nbsp;", ""));
                            else
                                incidentEntity.setCreateTime(Timestamp.valueOf(span.get(count).html()));
                            continue;
                        case 9:
                            if(span.get(count).html().toUpperCase().equals("ДА"))
                                incidentEntity.setRepet(1);
                            else
                                incidentEntity.setRepet(0);
                            continue;
                        case 10:
                            incidentEntity.setClazz(span.get(count).html());
                            continue;
                        case 18:
                            while (count < span.size())
                                if (span.get(count).html().startsWith("с ") && span.get(count).html().contains(" до "))
                                    break;
                                else
                                    count++;
                            out.println(n++ + "->" + "21 +---- >" +  span.get(count -1).html()); //workers
                            incidentEntity.setDecisionTime(Timestamp.valueOf(span.get(count).html().split("до")[1].split(" ")[2] + ' ' + span.get(count).html().split("до")[1].split(" ")[1]));
                            continue;
                        case 22:
                            incidentEntity.setNameClient(span.get(count).html());   // Имя клиента
                            continue;
                        case 23:
                            incidentEntity.setAddress(span.get(count).html());      // Адрес
                            continue;
                        case 24:
                            incidentEntity.setRoom(span.get(count).html());         // номер помещения
                            continue;
                        case 25:
                            incidentEntity.setPhone(Long.parseLong(span.get(count).html()));        // Номер телефона
                            continue;
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            if( !span.get(count).html().equals(TechData) && !span.get(count).html().equals("нет"))
                                CommentAll.append(span.get(count).html()).append(" ");
                            continue;
                        default:
                            if (span.get(count).childNodeSize() > 1)
                                out.println(n++ + "+->" +count + "---->" + span.get(count).childNode(0) + span.get(count++ + 1).html().replace("&nbsp;", ""));
                            else
                                out.println(n++ + "-->" +count + "->" + span.get(count).html());
                    }
                }
                out.println(n++ + "TD-->"  + TechData);
                out.println(n + "ComAll-->"  + CommentAll);
                record++;
            }
        }
        out.println( "Записей обработано ->" + record);
    }

}
