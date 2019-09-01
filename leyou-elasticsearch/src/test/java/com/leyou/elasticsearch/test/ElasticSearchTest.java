package com.leyou.elasticsearch.test;


import com.leyou.elasticsearch.pojo.Goods;
import com.leyou.elasticsearch.pojo.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

/**
 * @Description TODO
 * @Author yk
 * @Date 2019/9/1 14:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchTest {


    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testIndex(){
        // 索引
        elasticsearchTemplate.createIndex(Item.class);
        // 配置映射
        elasticsearchTemplate.putMapping(Item.class);
    }

    @Test
    public void testCreate(){
        SearchQuery searchQuery = new NativeSearchQueryBuilder().build();
        List<Goods> list = elasticsearchTemplate.queryForList(searchQuery, Goods.class);
        for(Goods g : list) {
            System.out.println(g);
        }

    }




}
