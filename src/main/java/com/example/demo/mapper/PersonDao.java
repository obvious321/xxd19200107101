package com.example.demo.mapper;

import com.example.demo.entity.Person;
import com.example.demo.Quary.PersonQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper  // 告诉springboot这是一个mybatis的mapper类
@Repository   // 将persondao交由spring容齐管理
public interface PersonDao {
    // 查询所有用户
    public List<Person> listPerson();
    // 根据id查询用户
    public Person queryPersonById(Integer id);
    // 根据用户名来查询用户  并分页展示
    public List<Person> listPersonByName(PersonQuery personQuery);
    //根据id删除用户
    public int deletePersonById(Integer id);
    // 修改用户
    public int updatePerson(Person person);
    // 新增用户
    public int addPerson(Person person);
}
