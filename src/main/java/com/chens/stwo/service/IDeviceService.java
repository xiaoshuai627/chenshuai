package com.chens.stwo.service;

/**
 * ClassName : IDeviceService
 * package : com.chens.stwo.service
 * Description :TODO
 *
 * @date :2020/4/6 15:56
 * @Author :xiaoshuai
 */
public interface IDeviceService {
    void addUseRec(String devicesId,String user);
    void stopUseDevice(int state, String deviceId);
}
