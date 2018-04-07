package com.feisher.akotlin.event;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/6 0006.
 */
public class Test implements Serializable {
    public String name;
    public int age;

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
