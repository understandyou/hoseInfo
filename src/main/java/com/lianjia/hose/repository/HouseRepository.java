package com.lianjia.hose.repository;

import com.lianjia.hose.entitys.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface HouseRepository extends JpaRepository<House,Integer>,JpaSpecificationExecutor<House> {
   // List<House> findAllBy
}
