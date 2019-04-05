package com.lianjia.hose.service.impl;

import com.lianjia.hose.entitys.House;
import com.lianjia.hose.repository.HouseRepository;
import com.lianjia.hose.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;
    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public List<House> findAll(House house) {
        Assert.notNull(house,"查询参数对象不能为空！");
        return houseRepository.findAll((Specification<House>) (root, criteriaQuery, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isEmpty(house.getCommunity())) {
                list.add(cb.like(root.get("community").as(String.class), "%" + house.getCommunity() + "%"));
            }
            if (house.getRidgepole()>0) {
                list.add(cb.equal(root.get("ridgepole").as(Long.class), house.getRidgepole()));
            }
            if (house.getUnit()>0) {
                list.add(cb.equal(root.get("unit").as(char.class), house.getUnit()));
            }
            if (house.getFloor()>0) {
                list.add(cb.equal(root.get("floor").as(Long.class), house.getFloor()));
            }
            if (!StringUtils.isEmpty(house.getHouserNumber())) {
                list.add(cb.equal(root.get("houserNumber").as(String.class), house.getHouserNumber()));
            }
            //将list中的条件返回
            return cb.and(list.toArray(new Predicate[list.size()]));
        });
    }
}
