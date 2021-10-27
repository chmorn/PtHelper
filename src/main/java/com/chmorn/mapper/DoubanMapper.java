package com.chmorn.mapper;

import com.chmorn.entity.DoubanEntity;
import org.springframework.stereotype.Repository;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenxu
 * @version 1.0
 * @className DouBanMapper
 * @description TODO
 * @date 2021/8/31
 **/
//@Mapper
@Repository
public interface DoubanMapper {

    /**
     * 查询总条数
     * @author chenxu
     * @date 2021/8/31
    **/
    int getCount();
    /**
     * 查询信息
     * @author chenxu
     * @date 2021/8/31
     **/
    DoubanEntity getDoubanInfo(/*@Param("doubanId")*/ String doubanId);
    /**
     * 新增信息
     * @author chenxu
     * @date 2021/9/6
     **/
    void addDoubanInfo(DoubanEntity entity);
}
