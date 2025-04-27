package com.example.mq.mqserver.core;
//MSG=>Message

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 *存储消息的队列
 */
public class MSGQueue {
    private String name; //队列的名字. 相当于队列的身份标识.
    private boolean durable = false; //队列是否要持久化存储. true 为持久化, false 不持久化.
    private boolean exclusive = false; //独有，队列只能被一个消费者使用.
    private boolean autoDelete = false; //使用完毕后是否自动删除. 预留字段, 暂时未使用.
    private Map<String, Object> arguments = new HashMap<>(); //队列的其他参数属性. 预留字段, 暂时未使用.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDurable() {
        return durable;
    }

    public void setDurable(boolean durable) {
        this.durable = durable;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public boolean isAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    public String getArguments() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(arguments);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    public void setArguments(String argumentsJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.arguments = objectMapper.readValue(argumentsJson, new TypeReference<HashMap<String, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Object getArguments(String key) {
        return arguments.get(key);
    }

    public void setArguments(String key, Object value) {
        arguments.put(key, value);
    }

    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }
}
