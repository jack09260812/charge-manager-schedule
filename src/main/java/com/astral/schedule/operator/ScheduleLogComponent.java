package com.astral.schedule.operator;

import com.astral.model.TTaskScheduleLog;
import com.astral.service.TaskScheduleLogService;
import com.astral.util.SpringHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/9/21.
 */
public class ScheduleLogComponent {

    private Logger logger = LoggerFactory.getLogger(ScheduleLogComponent.class);
    private TaskScheduleLogService taskScheduleLogService;
    private TTaskScheduleLog log;
    public ScheduleLogComponent(TTaskScheduleLog log){
        taskScheduleLogService = SpringHolder.getContext().getBean(TaskScheduleLogService.class);
        this.log = log;
    }

    public void execute(){
        boolean flg = taskScheduleLogService.add(log);
        if (flg){
            logger.info("message : {}","日志操作成功");
        }else {
            logger.info("Error Message: {}","日志操作失败");
        }
    }
}
