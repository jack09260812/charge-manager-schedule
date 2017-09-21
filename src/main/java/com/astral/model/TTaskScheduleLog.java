package com.astral.model;

import java.io.Serializable;
import java.util.Date;

public class TTaskScheduleLog implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 任务id，
     */
    private Integer taskId;

    /**
     * 任务执行状态，
     */
    private Integer status;

    /**
     * 调用的api接口
     */
    private String restApi;

    /**
     * 接口返回状态
     */
    private String code;

    /**
     * 接口返回信息
     */
    private String message;

    /**
     * 是否被删除，0未被删除，1被删除
     */
    private Integer deleted;

    /**
     * 任务开始时间
     */
    private Date startTime;

    private Date endTime;

    /**
     * 执行日期
     */
    private Date dt;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取任务id，
     *
     * @return task_id - 任务id，
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * 设置任务id，
     *
     * @param taskId 任务id，
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取任务执行状态，
     *
     * @return status - 任务执行状态，
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置任务执行状态，
     *
     * @param status 任务执行状态，
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取调用的api接口
     *
     * @return rest_api - 调用的api接口
     */
    public String getRestApi() {
        return restApi;
    }

    /**
     * 设置调用的api接口
     *
     * @param restApi 调用的api接口
     */
    public void setRestApi(String restApi) {
        this.restApi = restApi;
    }

    /**
     * 获取接口返回状态
     *
     * @return code - 接口返回状态
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置接口返回状态
     *
     * @param code 接口返回状态
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取接口返回信息
     *
     * @return message - 接口返回信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置接口返回信息
     *
     * @param message 接口返回信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取是否被删除，0未被删除，1被删除
     *
     * @return deleted - 是否被删除，0未被删除，1被删除
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否被删除，0未被删除，1被删除
     *
     * @param deleted 是否被删除，0未被删除，1被删除
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取任务开始时间
     *
     * @return start_time - 任务开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置任务开始时间
     *
     * @param startTime 任务开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取执行日期
     *
     * @return dt - 执行日期
     */
    public Date getDt() {
        return dt;
    }

    /**
     * 设置执行日期
     *
     * @param dt 执行日期
     */
    public void setDt(Date dt) {
        this.dt = dt;
    }
}