package hs.dcl.test.quartz.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @Description: 定时配置
 * @Author: weihb
 * @CreateDate: 2019/8/22 16:14
 * @Version: 1.0
 */
@Configuration
public class QuartzConfig {

    @Resource
    SpringJobFactory springJobFactory;


    @Bean(name = "stockIncentiveBean")
    public SchedulerFactoryBean schedulerFactoryBean() throws Exception {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(PropertiesUtil.loadQuartzProperties());
        factory.setJobFactory(springJobFactory);
        return factory;
    }

    /**
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean(name = "QuartzScheduler")
    public Scheduler scheduler() throws Exception {
        return schedulerFactoryBean().getScheduler();
    }
}
