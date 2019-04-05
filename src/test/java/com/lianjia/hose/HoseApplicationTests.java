package com.lianjia.hose;

import com.lianjia.hose.entitys.House;
import com.lianjia.hose.repository.HouseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HoseApplicationTests {

    @Autowired
    private HouseRepository houseRepository;
    @Test
    public void contextLoads() {
        System.out.println(houseRepository);
        House housee = new House();
        housee = null;
        Assert.notNull(housee,"这是异常消息");
        housee.setCommunity("宇众悦府");
        housee.setRidgepole(1l);
       /* List<House> community = houseRepository.findAll(new Specification<House>() {
            @Override
            public Predicate toPredicate(Root<House> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (!StringUtils.isEmpty(house.getCommunity())) {
                    list.add(cb.like(root.get("community").as(String.class), "%" + house.getCommunity() + "%"));
                }


                //将list中的条件返回
                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        });*/
       /* List<House> all = houseRepository.findAll((Specification<House>) (root, criteriaQuery, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isEmpty(housee.getCommunity())) {
                list.add(cb.like(root.get("community").as(String.class), "%" + housee.getCommunity() + "%"));
            }
            if (housee.getRidgepole()>0) {
                list.add(cb.equal(root.get("ridgepole").as(Long.class), housee.getRidgepole()));
            }
            if (housee.getUnit()>0) {
                list.add(cb.equal(root.get("unit").as(char.class), housee.getUnit()));
            }
            if (housee.getFloor()>0) {
                list.add(cb.equal(root.get("floor").as(Long.class), house.getFloor()));
            }
            if (!StringUtils.isEmpty(housee.getHouserNumber())) {
                list.add(cb.equal(root.get("houserNumber").as(String.class), housee.getHouserNumber()));
            }
            //将list中的条件返回
            return cb.and(list.toArray(new Predicate[list.size()]));
        });*/
       // System.out.println("结果--"+all.size());
    }

}
