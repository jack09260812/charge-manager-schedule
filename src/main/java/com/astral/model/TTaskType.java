package com.astral.model;

import java.io.Serializable;
import java.util.Date;

public class TTaskType implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 任务类型
     */
    private String type;

    /**
     * 是否被删除(0：未删除，1：删除)
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 创建日期
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
     * 获取任务类型
     *
     * @return type - 任务类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置任务类型
     *
     * @param type 任务类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取是否被删除(0：未删除，1：删除)
     *
     * @return deleted - 是否被删除(0：未删除，1：删除)
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否被删除(0：未删除，1：删除)
     *
     * @param deleted 是否被删除(0：未删除，1：删除)
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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
}