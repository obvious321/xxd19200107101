package com.example.demo.service;

import com.example.demo.Quary.TravelerQuary;
import com.example.demo.mapper.TravelerDao;
import com.example.demo.entity.Traveler;
import com.example.demo.mapper.TravelerDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //交给springboot管理
public class TravelerServiceImpl implements TravelerService{

    @Autowired
    private TravelerDao travelerDao;//注入dao层

    @Override
    public List<Traveler> listTraveler() {
        return travelerDao.listTraveler();
    }

    @Override
    public PageInfo<Traveler> listTravelerByname(TravelerQuary travelerQuary) {
        //启动PageHelper
        PageHelper.startPage(travelerQuary.getPageNum(),travelerQuary.getPageSize());
        return new PageInfo<Traveler>(travelerDao.ListTravelerByName(travelerQuary));
    }

    @Override
    public boolean deleteTravelerById(Integer id) {
        int i=travelerDao.deleteTravelerById(id);
        if(i>0){
            return  true;
        }else{
            return false;
        }
    }

    @Override
    public Traveler queryTravelerById(Integer id) {
        return travelerDao.queryTravelerById(id);
    }

    @Override
    public boolean updateTraveler(Traveler traveler) {
       int i= travelerDao.updateTraveler(traveler);
       if(i>0){
           return true;
       }else {
           return false;
       }
    }

    @Override
    public boolean addTraveler(Traveler traveler) {
         return travelerDao.addTraveler(traveler)>0 ? true:false;
    }



}
