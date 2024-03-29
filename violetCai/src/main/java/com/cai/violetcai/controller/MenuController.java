package com.cai.violetcai.controller;

import com.alibaba.fastjson.JSON;
import com.cai.violetcai.bean.MainMenu;
import com.cai.violetcai.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuDao menuDao;

    @RequestMapping("/menus")
    public String getAllMenus(@RequestParam("userId") int userId){
        HashMap<String, Object> data = new HashMap<>();
        List<MainMenu> menus = menuDao.getMenus(userId);
        if(menus != null){
            data.put("menus", menus);
            data.put("flag", 200);
        }else{
            data.put("flag", 404);
        }
        String s = JSON.toJSONString(data);
        return s;
    }

}
