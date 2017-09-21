package com.astral.service;

import com.astral.model.TTaskConfig;

import java.util.List;

public interface TaskConfigService {

    /**
     *
     * @param tTaskConfig
     * @return
     * 获取任务列表
     */
    public List<TTaskConfig> list(TTaskConfig tTaskConfig);

    /**
     *
     * @param tTaskConfig
     * @return
     * 根据任务名称获取实体对象
     */
    public TTaskConfig get(TTaskConfig tTaskConfig);

    /**
     *
     * @param id
     * @return
     * 根据任务id获取实体对象
     */
    public TTaskConfig getByPrimaryKey(Integer id);

    /**
     *
     * @param tTaskConfig
     * @return
     * 增加实体对象
     */
    public boolean add(TTaskConfig tTaskConfig);

    /**
     *
     * @param tTaskConfig
     * @return
     * 修改实体对象
     */
    public boolean update(TTaskConfig tTaskConfig);

    /**
     *
     * @param id
     * @return
     * 根据primarykey 删除实体对象
     */
    public boolean delete(Integer id);

}
