package com.example.demo;

import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    PersonDao personDao;
    @Test
    void contextLoads() {
        Person person = personDao.queryPersonById(1);
        System.out.println(person);


    }

}
