package ru.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("ru")
@PropertySource("classpath:app.properties")
@EnableJpaRepositories("ru.repository")
public class DataConfig {
    private static final String PROPERTIES_FILE = "properties";
    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";
    public static int START;
    public static int STOP;
    public static int INTERVAL;
    public static int INTERVAL_L;
    public static String FIREFOX;
    public static String LOGIN;
    public static String PASSWORD;

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource()  {
        Properties properties = new Properties();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            FileInputStream propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);
        } catch (IOException e) {
            System.err.println("Не найден файл " + PROPERTIES_FILE);
            e.printStackTrace();
        }
        START = Integer.parseInt(properties.getProperty("START"));
        STOP = Integer.parseInt(properties.getProperty("STOP"));
        LOGIN = properties.getProperty("LOGIN");
        PASSWORD = properties.getProperty("PASSWORD");
        INTERVAL = Integer.parseInt(properties.getProperty("INTERVAL"));
        INTERVAL_L = Integer.parseInt(properties.getProperty("INTERVAL_L"));
        FIREFOX = properties.getProperty("FIREFOX");
        System.out.println(properties.getProperty("dbdriver") );
        dataSource.setDriverClassName( properties.getProperty("dbdriver"));
        System.out.println(properties.getProperty("dburl"));
        dataSource.setUrl( properties.getProperty("dburl"));
        System.out.println(properties.getProperty("dbusername") );
        dataSource.setUsername( properties.getProperty("dbusername"));
        System.out.println(properties.getProperty("dbpassword") );
        dataSource.setPassword( properties.getProperty("dbpassword"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        properties.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
        return properties;
    }

}
