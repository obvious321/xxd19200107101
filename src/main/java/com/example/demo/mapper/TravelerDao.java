package com.example.demo.mapper;


import com.example.demo.Quary.TravelerQuary;
import com.example.demo.entity.Traveler;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//告诉springboot是一个mybatis的mapper
@Repository //将dao交由spring管理
public interface TravelerDao {
    //查询所有用户
    public List<Traveler> listTraveler();
    //根据id查询用户
    public Traveler queryTravelerById(Integer id);

    //根据用户名来查询用户，并分页展示
    public List<Traveler> ListTravelerByName(TravelerQuary traverlerQuary);

    //根据id删除用户
    public int deleteTravelerById(Integer id);

    //修改用户
    public int updateTraveler(Traveler traveler);

    //增加一个新增用户
    public int addTraveler(Traveler traveler);


}
