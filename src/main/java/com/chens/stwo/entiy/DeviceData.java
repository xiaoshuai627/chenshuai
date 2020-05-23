package com.chens.stwo.entiy;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
