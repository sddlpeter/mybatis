package com.powernode.mybatis.pojo;

import java.util.List;

public class Clazz {
    private String cid;
    private String cname;
    List<Student> students;

    public Clazz() {
    }


    public Clazz(String cid, String cname, List<Student> students) {
        this.cid = cid;
        this.cname = cname;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", students=" + students +
                '}';
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
