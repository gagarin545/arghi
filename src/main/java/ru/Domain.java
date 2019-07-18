package ru;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.parser.StoreInquiry;


public class Domain {

    public static void main(String[] args) throws InterruptedException {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();

        StoreInquiry storeInquiry = new StoreInquiry();
        storeInquiry.exec( ctx );
    }
}
