package com.ylf.cache.controller;

import com.ylf.cache.entity.Acount;
import com.ylf.cache.entity.AcountReq;
import com.ylf.cache.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ylf
 * @Time: 2019/7/25 下午4:28
 * @Description:
 */
@RestController
public class AcountController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AcountService service;

    @RequestMapping("/add")
    public String insertAcount(@RequestBody Acount acount){
        int n=service.insert(acount);
        if(n>0)
            return "success";
        else
            return "fail";
    }

    @RequestMapping("/selectSelective")
    public List<Acount> selectSelective(@RequestBody AcountReq acount){
        return service.getList(acount);
    }

    @RequestMapping("/test/{o}")
    public String test(@RequestBody Acount acount,@PathVariable("o") String o){
        return o+acount.getName();
    }

    @RequestMapping("/updateAcount")
    public List<Acount> updateAcount(@RequestBody Acount acount){
        return service.updateAcount(acount);
    }
}
