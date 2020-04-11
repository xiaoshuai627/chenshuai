package com.chens.stwo.mapper;

import com.chens.stwo.entiy.DeviceData;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * ClassName : ManageMapper
 * package : com.chens.stwo.mapper
 * Description :TODO
 *
 * @date :2020/4/6 16:18
 * @Author :xiaoshuai
 */
@Mapper
public interface ManageMapper {

    @Insert("insert into devices_data(devices_id,system_version,model,screen_msg,operator,state,brand,ecid) values(#{deviceId},#{systemVersion},#{model},#{screenMsg},#{operator},#{state},#{brand},#{ecid})")
    int insertDevicesData(DeviceData deviceData);

    @Update("update devices_data set system_version = #{systemVersion},model = #{model},screen_msg = #{screenMsg},operator = #{operator},brand = #{brand},state = #{state} ,ecid = #{ecid} where devices_id = #{deviceId}")
    int updateDevicesDate(DeviceData deviceData);

    @Update("update devices_data set state = #{state} where devices_id = #{deviceId}")
    int updateDeviceState(@Param("state") int state, @Param("deviceId") String deviceId);

    @Update("update devices_data set state = #{state} where devices_id = #{deviceId}")
    int updateState(@Param("state") int state, @Param("deviceId") String deviceId);

    @Update("update devices_data set task_id = #{taskId} where devices_id = #{deviceId}")
    int updateTaskId(@Param("taskId") String taskId, @Param("deviceId") String deviceId);

    @Results(id = "deviceData", value = {
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
            @Result(property = "taskId", column = "task_id"),
            @Result(property = "ecid", column = "ecid"),
            @Result(property = "phoneNum", column = "phone_num")
    })
    @Select("<script>" +
            "select * from devices_data " +
            "<where>" +
            "<if test=\"conditionMap.deviceId != null and conditionMap.deviceId!=''\"> devices_id = #{conditionMap.deviceId} </if>" +
            "<if test=\"conditionMap.brand != null and conditionMap.brand!=''\"> AND brand LIKE  CONCAT('%',#{conditionMap.brand},'%') </if>" +
            "<if test=\"conditionMap.model != null  and conditionMap.model!=''\"> AND model LIKE  CONCAT('%',#{conditionMap.model},'%') </if>" +
            "<if test=\"conditionMap.metrics != null  and conditionMap.metrics!=''\"> AND metrics LIKE  CONCAT('%',#{conditionMap.metrics},'%') </if>" +
            "<if test=\"conditionMap.taskState != null  and conditionMap.taskState!=''\"> AND state = #{conditionMap.taskState} </if>" +
            "</where>" +
            "</script>"
    )
    public List<DeviceData> searchDevices(@Param("conditionMap") Map<String, String> conditionMap);

    @ResultMap("deviceData")
    @Select("<script>" +
            "select * from devices_data" +
            "<where>" +
            "<if test=\"platform != null\"> operator = #{platform}</if>" +
            "</where>" +
            "</script>"
    )
    public List<DeviceData> getAllDevices(@Param("platform") String platform);

    @ResultMap("deviceData")
    @Select("select * from devices_data where devices_id = #{deviceId}")
    public DeviceData getDeviceById(@Param("deviceId") String deviceId);

    @ResultMap("deviceData")
    @Select("select * from devices_data where state = 1 and operator = #{platform} limit 1 for update")
    DeviceData getFreeDevice(@Param("platform") String platform);

    @Select("select state from devices_data where devices_id = #{deviceId}")
    String getDeviceState(@Param("deviceId") String deviceId);

    @Update("update devices_data set state=0 where brand='Apple' ")
    int offlineAllIOSDevice();

    @Update("<script>" +
            "update devices_data set state = #{state} where state&lt;&gt;0 and devices_id in " +
            "<foreach item='item' index='index' collection='deviceIdList' open='(' separator=',' close=')' >" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    int updateDevicesState(@Param("deviceIdList") List<String> deviceIdList, @Param("state") int state);

    @Select("select devices_id from devices_data where ecid = #{ecid}")
    String findUdid(@Param("ecid") String ecid);

    @Update("update devices_data set phone_num = #{phoneNum} where devices_id = #{deviceId}")
    int updatePhoneNum(@Param("phoneNum") String phoneNum, @Param("deviceId") String deviceId);

    @ResultMap("deviceData")
    @Select("select * from devices_data where state <> 0")
    public List<DeviceData> getOnlineDevices();
}
