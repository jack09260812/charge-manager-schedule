package com.astral.mapper;

import com.astral.model.TTaskScheduleLog;

import java.util.List;
import java.util.Map;

public interface TTaskScheduleLogMapper extends BaseMapper<TTaskScheduleLog, Integer> {

    public List<TTaskScheduleLog> selectByMap(Map<String,Object> map);
}