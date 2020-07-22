package com.chens.stwo.mapper;

import com.chens.stwo.entiy.DeviceLog;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName : DeviceLogMapper
 * package : com.chens.stwo.mapper
 * Description :TODO
 *
 * @date :2020/4/6 16:06
 * @Author :xiaoshuai
 */
@Mapper
public interface DeviceLogMapper {

    @Insert("insert into devices_log (devices_id,system_version,screen_msg,brand,cpu_msg," +
            "memory,state,model,metrics,operator,create_time,user) " +
            "values(#{deviceId},#{systemVersion}, #{screenMsg}, #{brand}, #{cpuMsg}," +
            " #{memory}, #{state}, #{model},#{metrics},#{operator},#{createTime},#{user});\n")
    int add(DeviceLog deviceLog);


    @Select("select * from devices_log where devices_id=#{deviceId} and state =0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "deviceId", column = "devices_id"),
            @Result(property = "systemVersion", column = "system_version"),
            @Result(property = "screenMsg", column = "screen_msg"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "cpuMsg", column = "cpu_msg"),
            @Result(property = "memory", column = "memory"),
            @Result(property = "state", column = "state"),
            @Result(property = "model", column = "model"),
            @Result(property = "metrics", column = "metrics"),
            @Result(property = "operator", column = "operator"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "user", column = "user")
    })
    DeviceLog findDeviceById(@Param("deviceId") String deviceId);

    @Select("select * from devices_log where state =0 and devices_id=#{deviceId}")
//    @ResultMap("deviceslog")
//    @Select("<script>" +
//            "select * from devices_log" +
//            "where state = 0" +
//            "<if test='deviceId != null'>" +
//            "and devices_id=#{deviceId}" +
//            " </if>" +
//            "</script>")
    List<DeviceLog> findAllDeviceslog(@Param("deviceId") String deviceId, @Param("user") String user);

    @Update("update devices_log set state=#{state} where device_id=#{deviceId}")
    int updateDevicelogByDeviceID(@Param("state") int state, @Param("deviceId") String deviceId);

    @Update("update devices_log set devices_id=#{deviceId},user=#{user}")
    void updateDevicelog(DeviceLog deviceLog);
}
