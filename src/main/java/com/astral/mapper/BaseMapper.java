package com.astral.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by jinwei.li on 2017/5/3 0003.
 */
public interface BaseMapper<T, K> {

    //插入
    int insert(T entity);

    //根据主键更新
    int update(T entity);

    int updateByIds(T entity);

    //根据主键删除
    int deleteByPrimaryKey(K id);

    int deleteByIds(T entity);

    int delete(T entity);

    //根据主键查询
    T selectByPrimaryKey(K id);

    List<T> select(T entity);
    
    //根据用户名模糊查询
    List<T> selectByName(T entity);
    
    List<T> selectByCondition(Map<String, Object> map);
    
    int updateOfNull(T entity);
}
