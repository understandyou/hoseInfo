package com.lianjia.hose.service;

import com.lianjia.hose.entitys.House;

import java.util.List;

public interface HouseService {
    /**
     * 查询所有
     * @return
     */
    List<House> findAll();

    /**
     * 根据条件，对象中内容为空的条件会自动忽略（对象不能为空）
     * @param house 查询条件
     * @return
     */
    List<House> findAll(House house);
}
