package com.astral.model;

import java.io.Serializable;
import java.util.Date;

public class TTaskConfig implements Serializable {
    private Integer id;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务类型id
     */
    private Integer taskTypeId;

    /**
     * 调度周期
     */
    private String cron;

    /**
     * 任务创建者
     */
    private Integer ownerId;

    /**
     * 任务负责人
     */
    private Integer chargeId;

    /**
     * 任务报警email
     */
    private String alarmAddress;

    /**
     * 任务状态;0未上线,1已上线
     */
    private Integer status;

    /**
     * 依赖任务
     */
    private String taskDeploy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 是否删除，0未删除，1删除
     */
    private Integer deleted;

    /**
     * 创建日期
     */
    private Date dt;

    /**
     * 任务内容，数组存储
     */
    private String taskContext;

    /**
     * 任务执行参数
     */
    private String param;

    /**
     * 任务描述
     */
    private String taskDescribe;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取任务名称
     *
     * @return task_name - 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置任务名称
     *
     * @param taskName 任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 获取任务类型id
     *
     * @return task_type_id - 任务类型id
     */
    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    /**
     * 设置任务类型id
     *
     * @param taskTypeId 任务类型id
     */
    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    /**
     * 获取调度周期
     *
     * @return cron - 调度周期
     */
    public String getCron() {
        return cron;
    }

    /**
     * 设置调度周期
     *
     * @param cron 调度周期
     */
    public void setCron(String cron) {
        this.cron = cron;
    }

    /**
     * 获取任务创建者
     *
     * @return owner_id - 任务创建者
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * 设置任务创建者
     *
     * @param ownerId 任务创建者
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取任务负责人
     *
     * @return charge_id - 任务负责人
     */
    public Integer getChargeId() {
        return chargeId;
    }

    /**
     * 设置任务负责人
     *
     * @param chargeId 任务负责人
     */
    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    /**
     * 获取任务报警email
     *
     * @return alarm_address - 任务报警email
     */
    public String getAlarmAddress() {
        return alarmAddress;
    }

    /**
     * 设置任务报警email
     *
     * @param alarmAddress 任务报警email
     */
    public void setAlarmAddress(String alarmAddress) {
        this.alarmAddress = alarmAddress;
    }

    /**
     * 获取任务状态;0未上线,1已上线
     *
     * @return status - 任务状态;0未上线,1已上线
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置任务状态;0未上线,1已上线
     *
     * @param status 任务状态;0未上线,1已上线
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取依赖任务
     *
     * @return task_deploy - 依赖任务
     */
    public String getTaskDeploy() {
        return taskDeploy;
    }

    /**
     * 设置依赖任务
     *
     * @param taskDeploy 依赖任务
     */
    public void setTaskDeploy(String taskDeploy) {
        this.taskDeploy = taskDeploy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取是否删除，0未删除，1删除
     *
     * @return deleted - 是否删除，0未删除，1删除
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除，0未删除，1删除
     *
     * @param deleted 是否删除，0未删除，1删除
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取创建日期
     *
     * @return dt - 创建日期
     */
    public Date getDt() {
        return dt;
    }

    /**
     * 设置创建日期
     *
     * @param dt 创建日期
     */
    public void setDt(Date dt) {
        this.dt = dt;
    }

    /**
     * 获取任务内容，数组存储
     *
     * @return task_context - 任务内容，数组存储
     */
    public String getTaskContext() {
        return taskContext;
    }

    /**
     * 设置任务内容，数组存储
     *
     * @param taskContext 任务内容，数组存储
     */
    public void setTaskContext(String taskContext) {
        this.taskContext = taskContext;
    }

    /**
     * 获取任务执行参数
     *
     * @return param - 任务执行参数
     */
    public String getParam() {
        return param;
    }

    /**
     * 设置任务执行参数
     *
     * @param param 任务执行参数
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     * 获取任务描述
     *
     * @return task_describe - 任务描述
     */
    public String getTaskDescribe() {
        return taskDescribe;
    }

    /**
     * 设置任务描述
     *
     * @param taskDescribe 任务描述
     */
    public void setTaskDescribe(String taskDescribe) {
        this.taskDescribe = taskDescribe;
    }
}