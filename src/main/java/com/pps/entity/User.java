package com.pps.entity;

import com.pps.core.annotion.AutoGenegrateId;

/**
 * @author
 * @discription;
 * @time 2020/7/30 17:20
 */
@AutoGenegrateId(name = "id")
public class User {


    private  Integer id;
    private  String name;
    private  Integer age2;
    private  Integer valuePps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge2() {
        return age2;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    public Integer getValuePps() {
        return valuePps;
    }

    public void setValuePps(Integer valuePps) {
        this.valuePps = valuePps;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age2=" + age2 +
                ", valuePps=" + valuePps +
                '}';
    }
}
