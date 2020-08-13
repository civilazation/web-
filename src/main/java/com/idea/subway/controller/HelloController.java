package com.idea.subway.controller;

import com.idea.subway.dao.SubwayDao;
import com.idea.subway.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
@Autowired
private SubwayDao subwayDao;

     @RequestMapping("/")
     //@ResponseBody
     String index(){
          User user = new User("zhangsan",18);
          subwayDao.save(user);
          return "index";
     }


}
