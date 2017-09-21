package com.astral.schedule.executor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.astral.model.TTaskConfig;
import com.astral.model.TTaskScheduleLog;
import com.astral.schedule.operator.ScheduleLogComponent;
import com.astral.service.TaskScheduleLogService;
import com.astral.util.SpringHolder;
import com.github.pagehelper.StringUtil;
import com.github.utils.HttpHelper;
import com.github.utils.date.DateHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 2017/9/20.
 * 实现http接口调用
 */
public class Executor implements Runnable{

    private final Logger logger = LoggerFactory.getLogger(Executor.class);

    private TTaskConfig tTaskConfig;
    /*执行异常调用报警接口*/
    private ExecutorReporter executorReporter;

    public Executor(TTaskConfig tTaskConfig){
        this.tTaskConfig = tTaskConfig;
    }
    @Override
    public void run() {
        logger.info("Schedule Task Running ! Task Name : " + tTaskConfig.getTaskName()
                +" Context : " +tTaskConfig.getTaskContext() );
        String url = tTaskConfig.getTaskContext();
        String param = tTaskConfig.getParam();
        Map<String,String> params = new HashMap<>();
        if (!StringUtil.isEmpty(param)){
            JSONObject jsonObject = JSON.parseObject(param);
            params = parseParams(jsonObject);
        }
        String code = null;
        try {
            TTaskScheduleLog log = getEntity();
            code = HttpHelper.doPostAsString(url,params);
            log.setCode("200");
            log.setEndTime(new Date());
            TaskScheduleLogService taskScheduleLogService =
                    SpringHolder.getContext().getBean(TaskScheduleLogService.class);
            taskScheduleLogService.add(log);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("请求异常，返回内容为：" + code);
        }
    }

    private TTaskScheduleLog getEntity(){
        TTaskScheduleLog log = new TTaskScheduleLog();
        log.setDeleted(0);
        try {
            log.setDt(new SimpleDateFormat("yyyy-MM-dd").parse(DateHelper.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.setStartTime(new Date());
        log.setTaskId(tTaskConfig.getId());
        log.setRestApi(tTaskConfig.getTaskContext());
        return log;
    }
    private Map<String,String> parseParams(JSONObject json){
        Map<String,String> map = new HashMap<>();
        Set<Map.Entry<String,Object>> set = json.entrySet();
        for (Map.Entry<String,Object> entry : set){
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            map.put(key,value);
        }
        return map;
    }
}
