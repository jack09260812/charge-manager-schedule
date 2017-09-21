package com.astral.schedule;

import com.astral.model.TTaskConfig;
import com.astral.service.TaskConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by admin on 2017/9/20.
 * 调度任务初始化
 */
public class ScheduleInitial {

    private Logger logger = LoggerFactory.getLogger(ScheduleInitial.class);

    private TaskConfigService taskConfigService;

    public ScheduleInitial(TaskConfigService taskConfigService){
        this.taskConfigService = taskConfigService;
    }

    /**
     * 加载已上线任务,写入到队列中
     */
    public void initial(){
        TTaskConfig tTaskConfig = new TTaskConfig() ;
        tTaskConfig.setStatus(1);
        tTaskConfig.setDeleted(0);
        List<TTaskConfig> list = taskConfigService.list(tTaskConfig);
        logger.info("The Online Task Schedule Size : " + list.size());
        for (TTaskConfig taskConfig : list){
            TaskSchedule.readyMQ.put(taskConfig.getId(),taskConfig);
        }
    }
}
