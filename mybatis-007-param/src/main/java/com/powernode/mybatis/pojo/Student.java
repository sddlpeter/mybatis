package com.powernode.mybatis.pojo;

import java.util.Date;

public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Character gender;
    private Date birthDate;

    public Student(Long id, String name, Integer age, Double height, Character sex, Date birthDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.gender = sex;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                '}';
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
