package com.chmorn.service;

import com.chmorn.entity.DoubanEntity;

/**
 * @author chenxu
 * @version 1.0
 * @className DouBanService
 * @description TODO
 * @date 2021/8/31
 **/
public interface DoubanService {
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
    DoubanEntity getDoubanInfo(String doubanId);
}
