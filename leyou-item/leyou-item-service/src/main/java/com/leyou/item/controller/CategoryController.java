package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @Author: yk
 * @Time: 2019-08-31
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);


    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(
            @RequestParam(value = "pid", defaultValue = "0") Long pid) {
        try {
            if (pid == null || pid < 0) {
                return ResponseEntity.badRequest().build();
            }
            List<Category> list = categoryService.queryCategoriesByPid(pid);
            if (CollectionUtils.isEmpty(list)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return ResponseEntity.ok(list);
        } catch (Exception e) {
            logger.error("queryCategoriesByPid error ", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }


}
