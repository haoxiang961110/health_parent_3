package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.entity.PageResult;
import com.itheima.health.mapper.CheckItemMapper;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: phx
 * @date: 2020/6/29
 * @time: 15:03
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
@Slf4j
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemMapper checkItemMapper;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<CheckItem> findAll() {
        return checkItemMapper.findAll();
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    @Override
    public CheckItem findOne(Integer id) {
        if (id == null) {
            log.error("CheckItemServiceImpl findOne is error id={}");
            throw new RuntimeException("id不能为空");
        }
        return checkItemMapper.findOne(id);
    }

    /**
     * 分页条件查询
     *
     * @param pageNum
     * @param pageSize
     * @param checkItem
     * @return
     */
    @Override
    public PageResult findByPage(Integer pageNum, Integer pageSize, CheckItem checkItem) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        Page<CheckItem> page = (Page<CheckItem>) checkItemMapper.findByPage(checkItem);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 新增
     *
     * @param checkItem
     */
    @Override
    public void add(CheckItem checkItem) {
        if (checkItem == null) {
            log.error("CheckItemServiceImpl add is error checkItem = {}");
            throw new RuntimeException("新增失败");
        }

        checkItemMapper.add(checkItem);
        if (checkItem.getId() == null) {
            log.error("CheckItemServiceImpl add is error id = {}");
            throw new RuntimeException("新增失败");
        }
    }

    /**
     * 更新
     *
     * @param checkItem
     */
    @Override
    public void update(CheckItem checkItem, Integer id) {
        if (id == null) {
            log.error("CheckItemServiceImpl update is error id={}");
            throw new RuntimeException("id不能为空");
        }
        if (checkItem == null) {
            log.error("CheckItemServiceImpl update is error checkItem = {}");
            throw new RuntimeException("更新失败");
        }
        CheckItem checkItem1 = checkItemMapper.findOne(id);
        if (checkItem1 == null) {
            log.error("CheckItemServiceImpl update is error");
            throw new RuntimeException("该对象不存在");
        }
        checkItem.setId(id);
        checkItemMapper.update(checkItem);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("CheckItemServiceImpl delete is error id={}");
            throw new RuntimeException("id不能为空");
        }
        checkItemMapper.delete(id);
    }
}
