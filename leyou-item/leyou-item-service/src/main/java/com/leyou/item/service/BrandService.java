package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;

import java.util.List;

/**
 * @Description TODO
 * @Author yk
 * @Date 2019/8/31 18:42
 */
public interface BrandService {

    PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, boolean desc);


    void saveBrand(Brand brand, List<Long> categories);



}
