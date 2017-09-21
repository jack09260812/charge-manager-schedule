package com.astral.schedule;

import com.astral.model.TTaskConfig;
import it.sauronsoftware.cron4j.Scheduler;

/**
 * Created by admin on 2017/9/20.
 */
public abstract class BaseTaskSchedule {

    public static Scheduler sche = new Scheduler();

    /**
     * 启动调度
     */
    public void start(){
        sche.start();

    }
    /**
     * 停止调度
     */
    public static void stop(){
        sche.stop();
    }

    public abstract void push(TTaskConfig tTaskConfig);
}
