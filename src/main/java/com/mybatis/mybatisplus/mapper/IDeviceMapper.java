package com.mybatis.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.mybatisplus.pojo.Device;
import com.mybatis.mybatisplus.pojo.Site;

import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/3 19:13
 */
public interface IDeviceMapper extends BaseMapper<Device> {
    List<Device> selectAllByUserId(Integer userId);
}
