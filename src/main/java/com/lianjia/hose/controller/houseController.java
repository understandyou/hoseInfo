package com.lianjia.hose.controller;

import com.lianjia.hose.entitys.House;
import com.lianjia.hose.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class houseController {
    @Autowired
    private HouseService houseService;
    @GetMapping("/Home.action")
    public ModelAndView getHome(House house){
        ModelAndView modelAndView = new ModelAndView("Home");
        List<House> all = null;
        if(checkHouseIsNull(house)){
            all = houseService.findAll();
        }
        else
        {
            //获得筛选结果
            all = houseService.findAll(house);
        }
        modelAndView.addObject("Houses", all);
        return modelAndView;
    }

    /**
     * 返回json
     * @param house
     * @return
     */
    @ResponseBody
    @GetMapping("/Houses.action")
    public List<House> getHouses(House house){
        List<House> all = null;
        if(checkHouseIsNull(house)){
            all = houseService.findAll();
        }
        else
        {
            //获得筛选结果
            all = houseService.findAll(house);
        }
        return all;
    }
    /**
     * 内容为空则返回true
     * @param house 需要检查的对象
     * @return 空：true，否则：false
     */
    private boolean checkHouseIsNull(House house){
        if(house.getId()==null&& house.getHouserNumber()==null&& house.getFloor()==null&& house.getUnit()==0&& house.getRidgepole()==null&& house.getCommunity()==null)
            return true;
        else
            return false;
    }
}
