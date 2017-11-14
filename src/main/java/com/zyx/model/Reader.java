package com.zyx.model;

public class Reader {
    private Integer id;

    private String name;

    private String sex;

    private String grade;

    private String dept;

    private Integer authority;

    private String password;

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
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                ", dept='" + dept + '\'' +
                ", authority=" + authority +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}