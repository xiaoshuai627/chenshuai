package com.chens.stwo.service.imp;

import com.chens.stwo.entiy.DeviceData;
import com.chens.stwo.entiy.DeviceLog;
import com.chens.stwo.mapper.DeviceLogMapper;
import com.chens.stwo.mapper.ManageMapper;
import com.chens.stwo.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class DeviceService implements IDeviceService {


    @Autowired
    private ManageMapper manageMapper;

    @Autowired
    private DeviceLogMapper deviceLogMapper;

    @Override
    public void addUseRec(String devicesId,String user) {
        //从设备表中获取到设备信息
        DeviceData deviceData = manageMapper.getDeviceById(devicesId);
        //修改手机状态
        manageMapper.updateDeviceState(2, devicesId);


        //添加使用记录
        DeviceLog deviceLog = new DeviceLog(devicesId, user, new Date());
        try {
            deviceLogMapper.add(deviceLog);
        }catch (DuplicateKeyException e) {
            deviceLogMapper.updateDevicelog(deviceLog);
        }

    }

    @Override
    public void stopUseDevice(int state, String deviceId) {
        manageMapper.updateDeviceState(1,deviceId);
        deviceLogMapper.updateDevicelogByDeviceID(state,deviceId);

    }

    @Override
    public DeviceLog findDeviceById(String deviceId) {
        return deviceLogMapper.findDeviceById(deviceId);
    }
}
