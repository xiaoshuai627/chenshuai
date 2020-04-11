package com.chens.stwo.entiy;

public class DeviceData {

    private String deviceId;            //设备序列号ID
    private String systemVersion = "";  //系统版本
    private String screenMsg;           //屏幕分辨率
    private String brand = "";          //手机品牌
    private String cpuMsg;              //cpu信息
    private String memory;              //内存
    private int state = 0;              //0手机下线、2自动化运行中，1空闲
    private String model = "";          //型号
    private String metrics = "";        //分辨率
    private String operator = "";       //操作系统
    private String taskId;
    private String ecid;
    private String phoneNum;
    private String img_url;             //图片地址

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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getEcid() {
        return ecid;
    }

    public void setEcid(String ecid) {
        this.ecid = ecid;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

}
