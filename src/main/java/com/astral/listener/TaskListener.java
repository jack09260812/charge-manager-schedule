package com.astral.listener;

import com.astral.schedule.ScheduleInitial;
import com.astral.schedule.TaskSchedule;
import com.astral.schedule.operator.ScheduleLogComponent;
import com.astral.service.TaskConfigService;
import com.astral.service.TaskScheduleLogService;
import com.astral.util.SpringHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * Created by admin on 2017/9/20.
 */
@WebListener
public class TaskListener implements ServletContextListener {

    private Logger log = LoggerFactory.getLogger(TaskListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("Initialize Task Schedule Data To Execute Queue!");
        TaskConfigService taskConfigService = SpringHolder.getContext().getBean(TaskConfigService.class);
        ScheduleInitial scheduleInitial = new ScheduleInitial(taskConfigService);
        //加载数据到执行队列中
        scheduleInitial.initial();
        TaskSchedule taskSchedule = new TaskSchedule();
        /*启动调度线程*/
        taskSchedule.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        TaskSchedule.stop();
        TaskSchedule.readyMQ.clear();
        TaskSchedule.runningMQ.clear();
    }
}
