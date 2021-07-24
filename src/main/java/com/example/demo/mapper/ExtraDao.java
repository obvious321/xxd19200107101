package com.example.demo.mapper;

import com.example.demo.entity.Extra;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExtraDao {
    public List<Extra> listExtra();
}
