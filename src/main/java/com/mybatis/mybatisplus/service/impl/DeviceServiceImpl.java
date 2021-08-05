package com.mybatis.mybatisplus.service.impl;

import com.mybatis.mybatisplus.mapper.IDeviceMapper;
import com.mybatis.mybatisplus.pojo.Device;
import com.mybatis.mybatisplus.service.DeviceService;
import com.mybatis.mybatisplus.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/3 19:14
 */
@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    IDeviceMapper deviceMapper;


    @Override
    public List<Device> findAllByUserId(Integer userId) {
        List<Device> devices = deviceMapper.selectAllByUserId(userId);
        return devices;
    }

    @Override
    public List<Device> findAllByLikeName(String likeName, Integer userId) {
        if (likeName==null||likeName.trim().equals("")){
            return deviceMapper.selectAllByUserId(userId);
        }
        String deviceLikeName='%'+likeName.trim()+'%';
        return deviceMapper.selectAllByLikeName(userId,deviceLikeName);
    }

    @Override
    public ResultVO addDevice(Device device) {
        int i = deviceMapper.insert(device);
        return i>0?ResultVO.ok("添加成功"):ResultVO.error("添加失败");
    }

    @Override
    public ResultVO deleteDevice(Integer deviceId) {
        int i = deviceMapper.deleteById(deviceId);
        return i>0?ResultVO.ok("删除成功"):ResultVO.error("删除失败");
    }

    @Override
    public ResultVO updateDevice(Device device) {
        int i = deviceMapper.updateById(device);
        return i>0?ResultVO.ok("更新成功"):ResultVO.error("更新失败");
    }

}
