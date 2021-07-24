package com.example.demo.service;

import com.example.demo.Quary.PersonQuery;
import com.example.demo.mapper.PersonDao;
import com.example.demo.entity.Person;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonDao personDao;
    @Override
    public List<Person> listPerson() {
        return personDao.listPerson();
    }
    @Override
    public PageInfo<Person> listPersonByName(PersonQuery personQuery) {
        PageHelper.startPage(personQuery.getPageNum(),personQuery.getPageSize());
        return new PageInfo<Person>(personDao.listPersonByName(personQuery));
    }
    @Override
    public boolean deletePersonById(Integer id) {
        int i = personDao.deletePersonById(id);
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Person queryPersonById(Integer id) {
        return personDao.queryPersonById(id);
    }
    @Override
    public boolean updatePerson(Person person) {
        int i = personDao.updatePerson(person);
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean addPerson(Person person) {
        return personDao.addPerson(person) > 0 ? true : false ;
    }
}
