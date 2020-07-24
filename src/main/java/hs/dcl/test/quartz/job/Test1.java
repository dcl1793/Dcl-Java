package hs.dcl.test.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.io.Serializable;

@Slf4j
public class Test1 implements Job, Serializable {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("执行定时任务2！");
    }
}
