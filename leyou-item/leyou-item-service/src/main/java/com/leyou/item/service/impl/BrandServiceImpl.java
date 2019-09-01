package com.leyou.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description TODO
 * @Author yk
 * @Date 2019/8/31 18:42
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, boolean desc) {

        // 1.分页
        PageHelper.startPage(page, rows);
        //  2.排序
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + (desc ? " DESC" : " ASC"));
        }
        // 3.查询
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", "%" + key + "%").orEqualTo("letter", key.toUpperCase());
        }
        List<Brand> list = brandMapper.selectByExample(example);
        //4.创建PageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(list);
        // 5.返回分页结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBrand(Brand brand, List<Long> categories) {
        // 新增品牌信息
        int i = brandMapper.insertSelective(brand);
        // 新增品牌和分类中间表
        if (i == 1){
            categories.forEach(cid ->{
                brandMapper.insertCategoryBrand(cid, brand.getId());
            });
        }
    }

}
