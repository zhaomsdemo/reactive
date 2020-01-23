package com.zjh.reactive.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;

@Data
@Document
public class User {

    @Id
    private String id;
    private String name;
    private Integer age;
    private Date birthDay;

    private HashMap attributes;

    public void put(String key,Object value){
        attributes.put(key,value);
    }

    public Object get(String key){
        return attributes.get(key);
    }
}
