package com.example.demo.service;


import com.example.demo.Quary.PersonQuery;
import com.example.demo.entity.Person;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    // 查询所有团员
    public List<Person> listPerson();
    // 根据团员名来查询团员  并分页展示
    public PageInfo<Person> listPersonByName(PersonQuery personQuery);
    //根据id删除团员
    public boolean deletePersonById(Integer id);
    // 根据id查询团员
    public Person queryPersonById(Integer id);
    // 修改团员
    public boolean updatePerson(Person person);
    // 新增团员
    public boolean addPerson(Person person);
}
