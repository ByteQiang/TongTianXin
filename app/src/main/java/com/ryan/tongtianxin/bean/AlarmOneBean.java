package com.ryan.tongtianxin.bean;

public class AlarmOneBean {
    private String carNumber;
    private String address;
    private String time;
    private String content;
    private String alarmNumber;

    public AlarmOneBean(String carNumber, String address, String time, String content, String alarmNumber) {
        this.carNumber = carNumber;
        this.address = address;
        this.time = time;
        this.content = content;
        this.alarmNumber = alarmNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAlarmNumber() {
        return alarmNumber;
    }

    public void setAlarmNumber(String alarmNumber) {
        this.alarmNumber = alarmNumber;
    }
}
