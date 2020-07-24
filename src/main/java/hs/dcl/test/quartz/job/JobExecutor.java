package hs.dcl.test.quartz.job;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Description: 执行器
 * @Author: weihb
 * @CreateDate: 2019/8/22 16:13
 * @Version: 1.0
 */
@Component
public class JobExecutor {

    private static Logger logger = LoggerFactory.getLogger(JobExecutor.class);

    @Value("${scheduler.group}")
    String jobGroup;

    @Resource(name = "QuartzScheduler")
    private Scheduler scheduler;


    @Value("messageSendJob")
    String messageSendJob;
    @Value("exerciseDataSyncJob")
    String exerciseDataSyncJob;

    @Value("${scheduler.messageSendJob}")
    String messageSendCronSchedule;
    @Value("${scheduler.exerciseDataSyncJob}")
    private String exerciseDataSyncCronSchedule;

    @PostConstruct
    public void initCronJob() {
        try {
            scheduleJob(messageSendJob, Test2.class, messageSendCronSchedule);
            scheduleJob(exerciseDataSyncJob, Test1.class, exerciseDataSyncCronSchedule);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("创建定时任务失败" + e);
        }
    }

    private void scheduleJob(String jobName, Class<? extends Job> jobClass, String cron) throws SchedulerException {

        //只是取消计划一个触发器,所以如果其他触发器引用此作业,它们将不会被更改.
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, jobGroup));
        //循环遍历所有引用此作业的触发器,以取消对它们的计划,从jobstore中删除作业
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroup));
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(JobKey.jobKey(jobName, jobGroup))
                .build();
        Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail)
                .withIdentity(TriggerKey.triggerKey(jobName, jobGroup))
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
