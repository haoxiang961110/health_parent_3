package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: phx
 * @date: 2020/6/29
 * @time: 15:03
 */
@RestController
@ControllerAdvice
@RequestMapping("/checkItem")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        List<CheckItem> checkItemList = checkItemService.findAll();

        return new Result(true, "查询成功", checkItemList);
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findOne(@PathVariable("id") Integer id) {
        CheckItem checkItem = checkItemService.findOne(id);
        return new Result(true, "查询成功", checkItem);
    }

    /**
     * 分页条件查询
     *
     * @param pageNum
     * @param pageSize
     * @param checkItem
     * @return
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public Result findByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @RequestBody CheckItem checkItem) {

        PageResult pageResult = checkItemService.findByPage(pageNum, pageSize, checkItem);
        return new Result(true,"查询成功",pageResult);
    }

    /**
     * 新增
     *
     * @param checkItem
     */
    @PostMapping
    public Result add(@RequestBody CheckItem checkItem) {
        checkItemService.add(checkItem);
        return new Result(true, "新增成功");
    }


    /**
     * 更新
     *
     * @param checkItem
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody CheckItem checkItem,@PathVariable("id") Integer id) {
        checkItemService.update(checkItem,id);
        return new Result(true,"更新成功");
    }


    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        checkItemService.delete(id);
        return new Result(true,"删除成功");
    }
}
