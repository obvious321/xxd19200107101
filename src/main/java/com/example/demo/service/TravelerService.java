package com.example.demo.service;

import com.example.demo.Quary.TravelerQuary;
import com.example.demo.entity.Traveler;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TravelerService {
    //查询所有用户
    public List<Traveler> listTraveler();
    //根据名字来查询活动 分页展示
    public PageInfo<Traveler> listTravelerByname(TravelerQuary travelerQuary);
    //根据id删除用户
    public boolean deleteTravelerById(Integer id);

    //根据id查询用户
    public Traveler queryTravelerById(Integer id);

    //修改用户
    public boolean updateTraveler(Traveler traveler);

    //增加一个新增用户
    public boolean addTraveler(Traveler traveler);


}
