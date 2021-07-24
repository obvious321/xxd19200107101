package com.example.demo.Quary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonQuery {
    private Integer pageNum = 1;   // 当前的页码
    private Integer pageSize  = 4;   //每一页所显示的数量
    private String name;    // 根据用户查询
}
