package com.astral.controller;

import com.alibaba.fastjson.JSONObject;
import com.astral.model.TTaskScheduleLog;
import com.astral.service.TaskScheduleLogService;
import com.astral.util.ResponseCode;
import com.github.utils.date.DateHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/9/21.
 */
@RestController
public class TaskScheduleLogController extends BaseController{

    @Resource
    private TaskScheduleLogService taskScheduleLogService;

    @RequestMapping("/log/list")
    public String list(TTaskScheduleLog log){
        JSONObject json = new JSONObject();
        return json.toString();
    }

    @RequestMapping("/log/logList")
    public String logList(HttpServletRequest request,HttpServletResponse response){
        JSONObject json = new JSONObject();
        Map<String,String[]> maps = request.getParameterMap();
        Map<String,Object> params = new HashMap<>();
        for (Map.Entry<String,String[]> entry : maps.entrySet()){
            String[] values = entry.getValue();
            for (String v : values){
                params.put(entry.getKey(),v);
            }
        }
        List<TTaskScheduleLog> list = taskScheduleLogService.list(params);
        if (list != null){
            json.put("code", ResponseCode.SYS_SUCCESS);
            json.put("message",ResponseCode.getMessage(ResponseCode.SYS_OPER_SUCCESS));
            json.put("data",list);
        }else {
            json.put("code", ResponseCode.SYS_ERROR);
            json.put("message",ResponseCode.getMessage(ResponseCode.SYS_OPER_FAIL));
        }
        return json.toString();
    }
    @RequestMapping("/log/add")
    public String add(TTaskScheduleLog tTaskScheduleLog){
        JSONObject json = new JSONObject();
        tTaskScheduleLog.setDeleted(0);
        String date = DateHelper.getDate();
        tTaskScheduleLog.setStartTime(new Date());
        boolean flg = taskScheduleLogService.add(tTaskScheduleLog);
        return json.toString();
    }
}
