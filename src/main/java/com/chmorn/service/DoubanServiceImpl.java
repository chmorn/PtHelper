package com.chmorn.service;

import com.chmorn.entity.DoubanEntity;
import com.chmorn.mapper.DoubanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenxu
 * @version 1.0
 * @className DouBanServiceImpl
 * @description TODO
 * @date 2021/8/31
 **/
@Service
public class DoubanServiceImpl implements DoubanService {

    //@Autowired
    //private DoubanMapper doubanMapper;

    @Override
    public int getCount() {
        return 0;
        //return doubanMapper.getCount();
    }

    @Override
    public DoubanEntity getDoubanInfo(String doubanId) {
        return null;
        //return doubanMapper.getDoubanInfo(doubanId);
    }

    @Override
    public void addDoubanInfo(DoubanEntity entity) {
        //doubanMapper.addDoubanInfo(entity);
    }
}
