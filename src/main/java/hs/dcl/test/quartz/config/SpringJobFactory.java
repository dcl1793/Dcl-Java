//package hs.dcl.test.quartz.config;
//
//import org.quartz.spi.TriggerFiredBundle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
//import org.springframework.scheduling.quartz.AdaptableJobFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @author ：wuhua19729
// * @date ：Created in 2019/4/23 17:21
// * @description：
// * @modified By：
// * @version: $
// */
//@Component
//public class SpringJobFactory extends AdaptableJobFactory {
//    @Autowired
//    private AutowireCapableBeanFactory capableBeanFactory;
//
//    @Override
//    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
//        // 调用父类的方法
//        Object jobInstance = super.createJobInstance(bundle);
//        // 进行注入
//        capableBeanFactory.autowireBean(jobInstance);
//        return jobInstance;
//    }
//
//
//}
