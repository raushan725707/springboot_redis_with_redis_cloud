package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {



    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/save")
    public String saveData(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "Data saved successfully!";
    }

    @GetMapping("/get")
    public Object getData(@RequestParam String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
