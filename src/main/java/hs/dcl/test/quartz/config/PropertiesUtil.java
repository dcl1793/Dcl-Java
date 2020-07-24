package hs.dcl.test.quartz.config;

import org.quartz.utils.PropertiesParser;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties loadQuartzProperties() throws IOException {
        Properties properties = loadProperties(new String[]{"config/quartz.properties", "classpath:/quartz.properties"});
        return getQuartzProperties(properties);
    }

    public static Properties loadProperties(String[] propertyResourceFiles) throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        AbstractResource resource = null;
        for (String file : propertyResourceFiles) {
            if (file.startsWith("classpath:")) {
                resource = new ClassPathResource(file.substring("classpath:".length()));
            } else {
                resource = new FileSystemResource(file);
            }
            if (resource.exists()) {
                break;
            }
        }
        propertiesFactoryBean.setLocation(resource);
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        Properties properties = propertiesFactoryBean.getObject();

        return properties;
    }

    public static Properties getQuartzProperties(Properties properties) {

        properties.setProperty("org.quartz.scheduler.instanceName", "-" + "QuartzScheduler");
        PropertiesParser propertiesParser = new PropertiesParser(properties);
        Properties quartzProperties = propertiesParser.getPropertyGroup("org.quartz");
        String[] dsNames = propertiesParser.getPropertyGroups("org.quartz.dataSource");
        for (String dsName : dsNames) {
            Properties propertyGroup = propertiesParser.getPropertyGroup("org.quartz.dataSource." + dsName, true);
            String user = propertyGroup.getProperty("user");
            String password = propertyGroup.getProperty("password");
            String encrypt = propertyGroup.getProperty("encrypt", "0");
            quartzProperties.setProperty("org.quartz.dataSource." + dsName + ".password", password);
        }

        return quartzProperties;
    }

}
