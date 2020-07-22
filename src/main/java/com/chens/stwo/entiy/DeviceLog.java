package com.chens.stwo.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceLog {
    private int id;
    private String deviceId;            //设备序列号ID
    private String systemVersion = "";  //系统版本
    private String screenMsg = "";         //屏幕分辨率
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

    public DeviceLog(String devicesId, String user, Date date) {
        this.deviceId = devicesId;
        this.user = user;
        this.createTime = date;
    }
}
