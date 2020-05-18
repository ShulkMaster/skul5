package com.example.skul5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "Student")
public class Student {

    public Student() {
    }

    @Id
    @Column(name = "id")
    private Integer code;

    @Column(name = "name")
    private String Name;

    @Column(name = "lastname")
    private String LastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "status")
    private Boolean status;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStateDelegate() {
        if (this.status == null) return "";
        return status ? "Active" : "Inactive";
    }
}
