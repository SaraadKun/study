package com.saraad.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Map;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: BroadCastBean
 * @Package:com.saraad.entity
 * @Description:
 * @author: saraad
 * @date: 2020/5/6 1:50
 * @Copyright: 2020  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
@Data
public class BroadCastBean {

    private String event_id;
    private Date event_time;
    private String front_type;
    private String platform_id;
    private String uid;
    private Integer server_id;
    private String os;
    private String city;
    private String province;
    private String country;
    private String room_id;
    private String room_name;
    private String project_id;
    private String staffName;
    private Long staytime;
    private String period_name;
    private String source;
    private String type;
    private String period_id;
    private String ehr;

    public static BroadCastBean buildFromJson(JSONObject obj){
        Assert.notNull(obj, "input json must not be null!");
        BroadCastBean bean = new BroadCastBean();
        bean.event_id = obj.getString("event_id");
        bean.front_type = obj.getString("front_type");
        bean.platform_id = obj.getString("platform_id");
        bean.uid = obj.getString("uid");
        bean.server_id = obj.getInteger("server_id");
        bean.os = obj.getString("os");
        bean.city = obj.getString("city");
        bean.province = obj.getString("province");
        bean.country = obj.getString("country");
        bean.event_time = new Date(obj.getLong("event_time"));
        JSONObject properties = obj.getJSONObject("properties");
        bean.room_id = properties.getString("room_id");
        bean.room_name = properties.getString("room_name");
        bean.project_id = properties.getString("project_id");
        bean.staffName = properties.getString("staffName");
        bean.period_id = properties.getString("period_id");
        bean.period_name = properties.getString("period_name");
        bean.source = properties.getString("source");
        bean.type = properties.getString("type");
        bean.ehr = properties.getString("ehr");
        bean.staytime = properties.getLong("staytime");
        return bean;

    }



}
