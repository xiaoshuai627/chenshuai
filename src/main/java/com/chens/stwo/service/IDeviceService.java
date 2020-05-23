package com.chens.stwo.service;

import com.chens.stwo.entiy.DeviceData;
import com.chens.stwo.entiy.DeviceLog;

import java.util.List;

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

    DeviceLog findDeviceById(String deviceId);

    List<DeviceLog> findAllDeviceslog(String deviceId, String user);
}
