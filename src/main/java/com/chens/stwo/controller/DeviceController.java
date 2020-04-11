package com.chens.stwo.controller;

import com.chens.stwo.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName : DeviceController
 * package : com.chens.stwo.controller
 * Description :TODO
 *
 * @date :2020/4/6 15:50
 * @Author :xiaoshuai
 */

@RestController
@RequestMapping(value = "/cloudDebug")
public class DeviceController {

    @Value("${stf.host}")
    private String stfurl;

    @Autowired
    private IDeviceService deviceService;

    @PostMapping(value = "/addUseRec")
    public String add(@RequestParam String devicesId, @RequestParam String user) {
        try {
            Map map = new HashMap();
            map.put("stf_url", stfurl + devicesId);
            deviceService.addUseRec(devicesId, user);
            return map.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "执行异常";
        }
    }


}
