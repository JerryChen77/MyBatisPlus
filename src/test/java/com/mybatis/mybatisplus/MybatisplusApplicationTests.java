package com.mybatis.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.mybatisplus.mapper.IDeviceMapper;
import com.mybatis.mybatisplus.mapper.IUserMapper;
import com.mybatis.mybatisplus.pojo.Device;
import com.mybatis.mybatisplus.pojo.Site;
import com.mybatis.mybatisplus.pojo.User;
import com.mybatis.mybatisplus.service.SiteService;
import com.mybatis.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisplusApplicationTests {
    @Autowired
    IUserMapper userMapper;
    @Autowired
    IDeviceMapper deviceMapper;
    @Autowired
    UserService userService;
    @Autowired
    SiteService siteService;
    @Test
    public void test0() {
        List<Device> devices = deviceMapper.selectAllByUserId(1);
        for (Device device : devices) {
            System.out.println("device = " + device);
        }
    }


    @Test
    public void contextLoads() {
        int row = userMapper.deleteById(1);
        System.out.println("row = " + row);
    }

    @Test
    public void test2(){
////        User user = new User(null,"李四","eminem","狂徒",23,"2323@qq.com",null);
//        int row = userMapper.insert(user);
//        System.out.println("row = " + row);
//        System.out.println("user.getId() = " + user.getId());
    }
    @Test
    public void test03(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge("age",18);
        List list = userMapper.selectMaps(queryWrapper);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void test04(){

        IPage page = new Page();
        page.setSize(3);
        page.setCurrent(1);
        IPage page1 = userMapper.selectPage(page, null);
        List records = page1.getRecords();
        for (Object record : records) {
            System.out.println("record = " + record);
        }


    }
    @Test
    public void test05(){
        List list = userService.loadUsers();
        System.out.println(list);
    }
    @Test
    public void test06(){
        Integer i = siteService.update(new Site(2, "广东工", 1));
        System.out.println(i);
    }@Test
    public void test07(){
        List<Device> devices = deviceMapper.selectAllByUserId(1);
        devices.forEach(System.out::println);
    }
}
