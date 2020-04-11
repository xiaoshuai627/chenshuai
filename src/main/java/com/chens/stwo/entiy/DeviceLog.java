package com.chens.stwo.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DeviceLog {
    private int id;
    private String deviceId;            //设备序列号ID
    private String systemVersion = "";  //系统版本
    private String screenMsg= "";         //屏幕分辨率
    private String brand = "";          //手机品牌
    private String cpuMsg = "";              //cpu信息
    private String memory = "";              //内存
    private int state = 1;              //0手机下线、2自动化运行中，1空闲
    private String model = "";          //型号
    private String metrics = "";        //分辨率
    private String operator = "";       //操作系统

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String user;

    public DeviceLog(String deviceId, String user,Date createTime) {
        this.deviceId = deviceId;
        this.user = user;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getScreenMsg() {
        return screenMsg;
    }

    public void setScreenMsg(String screenMsg) {
        this.screenMsg = screenMsg;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpuMsg() {
        return cpuMsg;
    }

    public void setCpuMsg(String cpuMsg) {
        this.cpuMsg = cpuMsg;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
