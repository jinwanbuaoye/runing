package com.example.mq.mqserver.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 交换机
 */
public class Exchange {
    private String name; //交换机的名字. 相当于交换机的身份标识.

    private ExchangeType exchangeType = ExchangeType.DIRECT; //type : 交换机的类型. 三种取值, DIRECT, FANOUT, TOPIC.
    private boolean durable = false; //交换机是否要持久化存储. true 为持久化, false 不持久化.
    private boolean autoDelete = false; //使用完毕后是否自动删除. 预留字段, 暂时未使用.
    private Map<String, Object> arguments = new HashMap<>(); //交换机的其他参数属性. 预留字段, 暂时未使用.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public boolean isDurable() {
        return durable;
    }

    public void setDurable(boolean durable) {
        this.durable = durable;
    }

    public boolean isAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    public Map<String, Object> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }
}
