package com.astral.service.impl;

import com.astral.mapper.TTaskConfigMapper;
import com.astral.model.TTaskConfig;
import com.astral.service.TaskConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("taskConfigService")
public class TaskConfigServiceImpl implements TaskConfigService{

    @Resource
    private TTaskConfigMapper tTaskConfigMapper;

    @Override
    public List<TTaskConfig> list(TTaskConfig tTaskConfig) {

       return tTaskConfigMapper.select(tTaskConfig);

    }

    @Override
    public TTaskConfig get(TTaskConfig tTaskConfig) {
        return null;
    }

    @Override
    public TTaskConfig getByPrimaryKey(Integer id) {
        return tTaskConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean add(TTaskConfig tTaskConfig) {
        int i = tTaskConfigMapper.insert(tTaskConfig);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(TTaskConfig tTaskConfig) {
       int i = tTaskConfigMapper.update(tTaskConfig);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        TTaskConfig tTaskConfig = getByPrimaryKey(id);
        tTaskConfig.setDeleted(1);
        boolean flg = update(tTaskConfig);
        return flg;
    }
}
