package com.mybatis.mybatisplus.controller;

import com.mybatis.mybatisplus.pojo.Device;
import com.mybatis.mybatisplus.service.DeviceService;
import com.mybatis.mybatisplus.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/3 21:50
 */
@RestController
@RequestMapping("/device")
@CrossOrigin
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping("/devices/{userId}")
    public ResultVO findAll(@PathVariable("userId") Integer userId){

        List<Device> allByUserId = deviceService.findAllByUserId(userId);
        return ResultVO.ok("查询成功",allByUserId);
    }
    @RequestMapping("/add")
    public ResultVO addDevice(@RequestBody Device device){
        return deviceService.addDevice(device);
    }

    @RequestMapping("/delete/{deviceId}")
    @ResponseBody
    public ResultVO deleteById(@PathVariable("deviceId") Integer deviceId){
        return deviceService.deleteDevice(deviceId);
    }

}
