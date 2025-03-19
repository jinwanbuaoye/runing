package com.example.demo.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class MessageInfo {

    private String from;

    private String to;

    private String message;
}
