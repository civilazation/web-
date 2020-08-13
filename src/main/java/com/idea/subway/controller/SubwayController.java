package com.idea.subway.controller;

import com.idea.subway.entity.Ticket;
import com.idea.subway.service.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class SubwayController {

    @Autowired
    private SubwayService subwayService;
    /**
     * @description 查询所有站点信息
     * @param model
     * @param response
     * @return String
     */
    @RequestMapping("/subway")
    String index(Model model, HttpServletResponse response){
        List<Map<String, Object>> listStationsName = subwayService.getAllStationName();
        model.addAttribute("listStationsName",listStationsName);
        return "index";
    }
    /**
     * @description 查询两个站点之间的信息
     * @param startId
     * @param endId
     * @param model
     * @return List<Map<String, Object>>
     */
    @RequestMapping("/find")
    //@ResponseBody
   String  find(@RequestParam("selectId") Integer startId,
                                    @RequestParam("selectId2") Integer endId,
                                    Model model,Map<String,Object> maps){
       if(startId==endId){
           maps.put("msg", "起始站点不能相同");
           return "redirect:/subway";
       }else{
           Ticket mapList = subwayService.getBetweenTwoStationAll(startId, endId);
           model.addAttribute("mapList",mapList);
       }
        return "index";
    }
}
