package com.ylf.cache.service;

import com.ylf.cache.dao.AcountMapper;
import com.ylf.cache.entity.Acount;
import com.ylf.cache.entity.AcountReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ylf
 * @Time: 2019/7/25 下午4:26
 * @Description:
 */
@Service
public class AcountService {

    @Autowired
    private AcountMapper dao;

    @CachePut(cacheNames = "acount")
    public int insert(Acount acount){
        return dao.insert(acount);
    }

    @Cacheable(cacheNames = "acount",key = "#acount.id",condition = "#acount.id!=null")
    public List<Acount> getList(AcountReq acount){
        System.out.println("form db");
        return dao.selectSelective(acount);
    }

    @Caching(put ={
            @CachePut(value = "acount",key = "#acount.id")
    },
    evict = {
            @CacheEvict(value = "acount",key = "1")
    })
    public List<Acount> updateAcount(Acount acount){
        if(dao.updateAcount(acount)>0){
            ArrayList<Acount> list=new ArrayList<>();
            list.add(acount);
            return list;
        }
        else{
            return null;
        }
    }


}
