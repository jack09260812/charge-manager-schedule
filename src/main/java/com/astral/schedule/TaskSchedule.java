package com.astral.schedule;

import com.astral.model.TTaskConfig;
import com.astral.schedule.executor.Executor;
import com.github.pagehelper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 2017/9/20.
 */
public class TaskSchedule extends BaseTaskSchedule {

    private final Logger logger = LoggerFactory.getLogger(TaskSchedule.class);
    /*执行队列*/
    public static volatile ConcurrentHashMap<Integer, String> runningMQ = new ConcurrentHashMap<>();
    /*数据初始化队列*/
    public static volatile ConcurrentHashMap<Integer, TTaskConfig> readyMQ = new ConcurrentHashMap<>();

    private TTaskConfig tTaskConfig;

    public TaskSchedule() {
        this(null);
        init();
    }

    public TaskSchedule(TTaskConfig tTaskConfig) {
        this.tTaskConfig = tTaskConfig;
    }

    /**
     * 实现初始化数据
     */
    private void init() {
        for (Map.Entry<Integer, TTaskConfig> entry : readyMQ.entrySet()) {
            TTaskConfig tTaskConfig = entry.getValue();
            push(tTaskConfig);
        }
    }

    @Override
    public void push(TTaskConfig tTaskConfig) {
        logger.info("Add Task To Schedule,Task Information : TaskId="
                + tTaskConfig.getId() +";TaskName=" + tTaskConfig.getTaskName()
                +";RestAPI="+tTaskConfig.getTaskContext()+";Params="+tTaskConfig.getParam());
        runningMQ.put(tTaskConfig.getId(), sche.schedule(tTaskConfig.getCron(), new Executor(tTaskConfig)));
    }

    /**
     * 根据任务id remove 队列中的任务同时取消调度
     *
     * @param id
     */
    public void remove(Integer id) {
        //从任务添加队列中获取上线任务id
        /*taskId 为schedule时生成的uuid*/
        String taskId = runningMQ.get(id);
        if (StringUtil.isEmpty(taskId)) {
            //从初始化队列中获取已经上线任务id,然后根据id remove掉对象
            //释放对象占用空间
            TTaskConfig tTaskConfig = readyMQ.get(id);
            taskId = String.valueOf(tTaskConfig.getId());
            readyMQ.remove(id);
        }
        logger.info("Remove Task Schedule ID : " + taskId +";Task ID="+id);
        sche.deschedule(taskId);
        runningMQ.remove(id);
    }

    public void run() {
        logger.info("Task Schedule start !");
        if (tTaskConfig != null && tTaskConfig.getId() != null &&
                runningMQ.get(this.tTaskConfig.getId()) == null) {
            push(this.tTaskConfig);
        }
    }
}
