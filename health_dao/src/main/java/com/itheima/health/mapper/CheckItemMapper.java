package com.itheima.health.mapper;

import com.itheima.health.entity.PageResult;
import com.itheima.health.pojo.CheckItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: phx
 * @date: 2020/6/29
 * @time: 14:37
 */
@Mapper
public interface CheckItemMapper {
    /**
     * 查询所有
     * @return
     */
    List<CheckItem> findAll();

    /**
     * 查询单个
     * @param id
     * @return
     */
    CheckItem findOne(Integer id);

    /**
     * 分页条件查询
     * @param checkItem
     * @return
     */
    List<CheckItem> findByPage(CheckItem checkItem);

    /**
     * 新增
     * @param checkItem
     */
    void add(CheckItem checkItem);


    /**
     * 更新
     * @param checkItem
     */
    void update(CheckItem checkItem);


    /**
     * 删除
     * @param id
     */
    void delete(Integer id);
}
