package com.astral.model;

import java.io.Serializable;
import java.util.Date;

public class TTaskDeploy implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 当前任务id
     */
    private Integer currentId;

    /**
     * 所依赖的任务id
     */
    private Integer parentId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 是否删除；0未删除，1删除
     */
    private Integer deleted;

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
     * 获取当前任务id
     *
     * @return current_id - 当前任务id
     */
    public Integer getCurrentId() {
        return currentId;
    }

    /**
     * 设置当前任务id
     *
     * @param currentId 当前任务id
     */
    public void setCurrentId(Integer currentId) {
        this.currentId = currentId;
    }

    /**
     * 获取所依赖的任务id
     *
     * @return parent_id - 所依赖的任务id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置所依赖的任务id
     *
     * @param parentId 所依赖的任务id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
     * 获取是否删除；0未删除，1删除
     *
     * @return deleted - 是否删除；0未删除，1删除
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除；0未删除，1删除
     *
     * @param deleted 是否删除；0未删除，1删除
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
}