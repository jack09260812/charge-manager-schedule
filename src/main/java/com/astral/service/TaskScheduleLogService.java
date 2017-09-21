package com.astral.service;

import com.astral.model.TTaskScheduleLog;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by admin on 2017/9/21.
 */
public interface TaskScheduleLogService {

    /**
     *
     * @return
     * 获取日志列表
     */
    public List<TTaskScheduleLog> list(Map<String,Object> map);

    /**
     * @param map
     * @return
     * 根据日期区间,任务id
     */
    public List<TTaskScheduleLog> selectByTask(Map<String,Object> map);

    /**
     * @param id
     * @return
     * 根据日志id获取日志信息
     */
    public TTaskScheduleLog selectByLogId(Integer id);

    /**
     * 删除日志
     * @param id
     * @return
     */
    public boolean deleteByLogId(Integer id);

    /**
     * @param tTaskScheduleLog
     * @return
     * 更新日志
     */
    public boolean update(TTaskScheduleLog tTaskScheduleLog);

    /**
     * @param tTaskScheduleLog
     * @return
     * 新增日志
     */
    public boolean add(TTaskScheduleLog tTaskScheduleLog);
}
