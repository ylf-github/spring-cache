package com.ylf.cache.dao;

import com.ylf.cache.entity.Acount;
import com.ylf.cache.entity.AcountReq;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface AcountMapper {

    int insert(Acount record);

    int updateAcount(Acount acount);


    List<Acount> selectSelective(AcountReq acount);
}