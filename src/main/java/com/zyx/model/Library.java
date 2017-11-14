package com.zyx.model;

import java.util.Date;

public class Library {
    private Integer recod;

    private Date btime;

    private Date rtime;

    @Override
    public String toString() {
        return "Library{" +
                "recod=" + recod +
                ", btime=" + btime +
                ", rtime=" + rtime +
                ", bdays=" + bdays +
                ", readerId=" + readerId +
                ", bookId='" + bookId + '\'' +
                ", status=" + status +
                '}';
    }

    private Integer bdays;

    private Integer readerId;

    private String bookId;

    private Integer status;

    public Integer getRecod() {
        return recod;
    }

    public void setRecod(Integer recod) {
        this.recod = recod;
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public Integer getBdays() {
        return bdays;
    }

    public void setBdays(Integer bdays) {
        this.bdays = bdays;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}