package com.saraad.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.saraad.entity.BroadCastBean;
import jdk.nashorn.internal.scripts.JD;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class RawDataListener {
    static String enter_broadcast = "enter_broadcast";
    static String exit_broadcast = "exit_broadcast";
    static String default_platform = "wechat.rhjs";
    static String default_frontType = "public";

     /**
     * 实时获取kafka数据(生产一条，监听生产topic自动消费一条)
     * @param record
     * @throws IOException
     */
     @KafkaListener(topics = {"${kafka.consumer.topic}"}, groupId = "${kafka.consumer.group.id1}")
     public void listen(ConsumerRecord<?, ?> record) throws IOException {
        String key = (String) record.key();
        String value = (String) record.value();
        JSONObject jsonObject = JSON.parseObject(value);
        String platformId = jsonObject.getString("platform_id");
        String eventId = jsonObject.getString("event_id");
        String frontType = jsonObject.getString("front_type");
        if (default_platform.equals(platformId) && default_frontType.equals(frontType)){
            dealWithEvent(jsonObject);
        }
     }

    private void dealWithEvent(JSONObject jsonObject) {
        BroadCastBean castBean = BroadCastBean.buildFromJson(jsonObject);
        StringBuilder builder = new StringBuilder();
        builder.append(castBean.getEvent_id())
                .append(" : ")
                .append(JSON.toJSONString(castBean));
        System.out.println(builder.toString());
    }

//    private void dealWithEnterEvent(JSONObject jsonObject) {
//        StringBuilder builder = new StringBuilder();
//        builder.append(jsonObject.getString("event_id"))
//                .append(" : ")
//                .append(jsonObject.toJSONString());
//        System.out.println(builder.toString());
//    }
//
//    /**
//     * 第二个消费者组
//     * @param record
//     * @throws IOException
//     */
//     @KafkaListener(topics = {"${kafka.consumer.topic}"}, groupId = "${kafka.consumer.group.id2}")
//     public void listen2(ConsumerRecord<?, ?> record) throws IOException {
//        String key = (String) record.key();
//        String value = (String) record.value();
//        System.out.println("listener2: " + key + ":" + value);
//     }
 
 }