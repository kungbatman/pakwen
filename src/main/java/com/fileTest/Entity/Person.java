package com.fileTest.Entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.List;

/**
 * @author kung
 * @date 2019-07-02 16:48
 * @Description
 */
public class Person {
    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatcode() {
        return platcode;
    }

    public void setPlatcode(String platcode) {
        this.platcode = platcode;
    }

    private String id;
    private String name;
    private String platcode;
    private String qty;

    private List<Person> rel;

    public String toString() {
        String str = "name: " + name + "qty: " + qty + " platcode: " + platcode + " rel: " + rel;
        return str;
    }

    public List<Person> getRel() {
        return rel;
    }

    public void setRel(List<Person> rel) {
        this.rel = rel;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
