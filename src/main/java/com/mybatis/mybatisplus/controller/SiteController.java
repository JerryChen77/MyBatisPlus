package com.mybatis.mybatisplus.controller;

import com.mybatis.mybatisplus.pojo.Site;
import com.mybatis.mybatisplus.service.SiteService;
import com.mybatis.mybatisplus.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/3 18:58
 */
@RestController
@RequestMapping("/site")
@CrossOrigin
public class SiteController {

    @Autowired
    SiteService siteService;

    @RequestMapping("/sites/{userId}")
    @ResponseBody
    public ResultVO findAll(@PathVariable("userId") Integer userId){
        ResultVO resultVO = siteService.selectByUserId(userId);
        return resultVO;
    }

    @RequestMapping("/delete/{siteId}")
    @ResponseBody
    public ResultVO deleteById(@PathVariable("siteId") Integer siteId){
        siteService.DeleteById(siteId);
        return ResultVO.ok("删除成功");
    }
    @RequestMapping("/add")
    public ResultVO addSite(@RequestBody Site site){
        Integer i = siteService.insert(site);
       return i>0?ResultVO.ok("添加成功"):ResultVO.error("添加失败");
    }
    @RequestMapping("/update")
    public ResultVO updateSite(@RequestBody Site site){
        Integer i = siteService.update(site);
       return i>0?ResultVO.ok("修改成功"):ResultVO.error("修改失败");
    }
    @RequestMapping("/sites")
    public List<Site> selectAll(){
        return siteService.seletAll();
    }
}
