package com.zyx.model;

import java.util.Date;

public class Book {
    private String id;

    private Integer number;

    private String name;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", time=" + time +
                ", press='" + press + '\'' +
                ", bkcontext='" + bkcontext + '\'' +
                '}';
    }

    private String writer;

    private Date time;

    private String press;

    private String bkcontext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer == null ? null : writer.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getBkcontext() {
        return bkcontext;
    }

    public void setBkcontext(String bkcontext) {
        this.bkcontext = bkcontext == null ? null : bkcontext.trim();
    }
}