package com.leyou.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @Author: 98050
 * Time: 2018-10-11 16:43
 * Feature: 启动器，开启fegin功能
 */
@SpringBootApplication
public class LyElasticSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyElasticSearchApplication.class,args);
    }
}
