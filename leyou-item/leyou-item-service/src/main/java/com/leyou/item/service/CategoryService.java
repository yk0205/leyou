package com.leyou.item.service;


import com.leyou.item.pojo.Category;

import java.util.List;

/**
 *
 * @Author: yk
 * @Time: 2019-08-31
 */
public interface CategoryService {


    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    List<Category> queryCategoriesByPid(Long pid);



}
