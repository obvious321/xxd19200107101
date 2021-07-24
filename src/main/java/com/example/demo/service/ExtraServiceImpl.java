package com.example.demo.service;

import com.example.demo.entity.Extra;
import com.example.demo.mapper.ExtraDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExtraServiceImpl implements ExtraService{
    @Autowired
    private ExtraDao extraDao;

    @Override
    public List<Extra> listExtra(){
        return extraDao.listExtra();
    }
}
