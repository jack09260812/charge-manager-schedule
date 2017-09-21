package com.astral.service.impl;

import com.astral.mapper.TTaskScheduleLogMapper;
import com.astral.model.TTaskScheduleLog;
import com.astral.service.TaskScheduleLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/9/21.
 */
@Service("taskScheduleLogService")
public class TaskScheduleLogServiceImpl implements TaskScheduleLogService {

    @Resource
    private TTaskScheduleLogMapper tTaskScheduleLogMapper;

    @Override
    public List<TTaskScheduleLog> list(Map<String,Object> map) {
        return tTaskScheduleLogMapper.selectByMap(map);
    }

    @Override
    public List<TTaskScheduleLog> selectByTask(Map<String, Object> map) {
        return tTaskScheduleLogMapper.selectByCondition(map);
    }

    @Override
    public TTaskScheduleLog selectByLogId(Integer id) {
        return tTaskScheduleLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteByLogId(Integer id) {
        TTaskScheduleLog tTaskScheduleLog = tTaskScheduleLogMapper.selectByPrimaryKey(id);
        tTaskScheduleLog.setDeleted(1);
        int i = tTaskScheduleLogMapper.update(tTaskScheduleLog);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(TTaskScheduleLog tTaskScheduleLog) {
        int i = tTaskScheduleLogMapper.update(tTaskScheduleLog);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(TTaskScheduleLog tTaskScheduleLog) {
        int i = tTaskScheduleLogMapper.insert(tTaskScheduleLog);
        if (i>0){
            return true;
        }
        return false;
    }
}
