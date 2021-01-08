package com.wdznmy.goods.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wxh
 * @version 1.0
 * @date 2021/1/9 5:00
 * @description
 */
public class SystemController {

    @GetMapping
    public String status() {
        int i = 100/0;
        int a = 100;
        a = 200;
        return "成功";
    }
}
