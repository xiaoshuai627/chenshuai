package com.chens.stwo.controller;

import com.chens.stwo.entiy.DeviceLog;
import com.chens.stwo.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName : DeviceSearchController
 * package : com.chens.stwo.controller
 * Description :TODO
 *
 * @date :2020/4/25 15:34
 * @Author :xiaoshuai
 */
@RestController
@RequestMapping(value = "/device")
public class DeviceSearchController {

    @Autowired
    private IDeviceService deviceService;

    @GetMapping(value = "/findById")
    public String findDeviceById(@RequestParam("deviceId") String deviceId) {
        DeviceLog deviceLog = deviceService.findDeviceById(deviceId);
        return deviceLog.toString();
    }

    @GetMapping(value = "/findAllDeviceslog")
    public List<DeviceLog> findAllDeviceslog(@RequestParam("deviceId") String deviceId, @RequestParam("user") String user) {
        return deviceService.findAllDeviceslog(deviceId,user);
    }
}
